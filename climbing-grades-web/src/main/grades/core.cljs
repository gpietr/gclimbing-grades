(ns grades.core
  (:require [clojure.string :as str]
            [grades.mappings :refer [bouldering-grades-mapping
                                     sport-grades-mapping]]
            [reagent.core :as rcore]
            [reagent.dom :as r]))

(defn ^:dev/after-load start []
  (js/console.log "start"))




(defn background-color-scale [n max]
  (let [ratio (/ n max)
        ; Define the colors as [red green blue]
        green [0 255 0]   ; Green
        yellow [255 255 0] ; Yellow
        red [255 0 0]     ; Red
        black [0 0 0]     ; Black

        ; Function to interpolate between two colors
        interpolate (fn [c1 c2 t]
                      (mapv #(+ (* t (- %2 %1)) %1) c1 c2))

        ; Determine which segment the number falls into
        ; and calculate the interpolation ratio within that segment
        ; The range is split into three equal parts
        color (cond
                (< ratio 0.33) (interpolate green yellow (* 3 ratio))
                (< ratio 0.66) (interpolate yellow red (/ (- (* 3 ratio) 1) 1))
                :else (interpolate red black (/ (- (* 3 ratio) 2) 1)))]

    (apply str "#" (map (fn [x] (-> x (Math/round) (.toString 16) (.padStart 2 "0"))) color))))
   
(defn font-color-scale [n max]
  (let [ratio (/ n max)]

    (if (< ratio 0.75)
      "#000000"
      "#ffffff")))
  

(def yosemite-grades (keys sport-grades-mapping))

(def yosemite-grades-to-index (zipmap yosemite-grades (range)))

(def v-grades (keys bouldering-grades-mapping))

(def v-grades-to-index (zipmap v-grades (range)))

(defn render-enter-grade-form [] 
  [
   :form {:class "grid"}
   [:input {:type "text" :id "grade" :name "grade"}]
   [:button {:type "submit"} "Submit"]])
   

(defn render-sport-grades-table []
  [:table {:class "grades-table"}
   [:thead
    [:tr
     [:th "YDS"]
     [:th "French"]
     [:th "UIAA"]
     [:th "Kurtyki (Polish)"]
     [:th "British-tech"]
     [:th "Australian"]
     ]] 
   [:tbody
    (map (fn [yosemite-grade]
           (let [grade-index (get yosemite-grades-to-index yosemite-grade)]
             [:tr {:key yosemite-grade :style {:background-color (background-color-scale grade-index 36) :color (font-color-scale grade-index 36)}}
              [:td yosemite-grade]
              [:td (get (get sport-grades-mapping yosemite-grade) :French)]
              [:td (get (get sport-grades-mapping yosemite-grade) :UIAA)]
              [:td (get (get sport-grades-mapping yosemite-grade) :Kurtyki)]
              [:td (get (get sport-grades-mapping yosemite-grade) :British-Tech)]
              [:td (get (get sport-grades-mapping yosemite-grade) :Australian)]
              ]))
         yosemite-grades)]])

(defn render-bouldering-grades-table []
  [:table {:class "grades-table"}
   [:thead
    [:tr
     [:th "Fontainebleau"]
     [:th "V"]]]
   [:tbody
    (map (fn [v-grade]
           (let [grade-index (get v-grades-to-index v-grade)]
             [:tr {:key v-grade :style {:background-color (background-color-scale grade-index 19) :color (font-color-scale grade-index 19)}}
              [:td (get (get bouldering-grades-mapping v-grade) :FB-Grade)]
              [:td v-grade]]))
         v-grades)]])

(def tabs {
           :bouldering-grades ::bouldering-grades 
           :sport-grades ::sport-grades 
           :all-grades ::all-grades})

(def current-tab (rcore/atom (:bouldering-grades tabs)))

(defn fully-qualified-name-to-key-string [fqn]
  (-> fqn
       (str/split "/")
       (last)))

(defn render-nav-item [tab-name tab-id]
  [:li {:class (str (fully-qualified-name-to-key-string tab-id) (if (= @current-tab tab-id) " active" ""))} 
   [:a { :href "#" :onClick (fn [] (swap! current-tab (fn [_] tab-id)))} tab-name]])

(defn render []
  [:div
  ;;  (render-enter-grade-form)
   [:nav {:role "tab-control" :class "nav-tabs"}
    [:ul
     (render-nav-item "Bouldering" (:bouldering-grades tabs))
     (render-nav-item "Sport" (:sport-grades tabs))
     ]]
     
   [:div {:role "tabs"}
    (case @current-tab
      ((:bouldering-grades tabs)) (render-bouldering-grades-table)
      ((:sport-grades tabs)) (render-sport-grades-table)
      )]])
    
   

(defn init []
  (start)
  (r/render
    [render]
    (.getElementById js/document "root")))
  


