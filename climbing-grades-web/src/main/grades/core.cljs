(ns grades.core
  (:require [reagent.dom :as r] [reagent.core :as rcore]))

(defn ^:dev/after-load start []
  (js/console.log "start"))

(def grades-mapping (array-map "5.0" {:UIAA "1", :French "1", :Sax-Swiss "I", :British-Tech "1", :British-Adj "M", :Nordic-Fin "1", :Nordic-Swe/Nor "1", :FB-Grade "1", :V-Grade "VB-", :Kurtyki "I"}
                               "5.1" {:UIAA "2", :French "2", :Sax-Swiss "II", :British-Tech "2", :British-Adj "M/D", :Nordic-Fin "2", :Nordic-Swe/Nor "2", :FB-Grade "1", :V-Grade "VB-", :Kurtyki "II"}
                               "5.2" {:UIAA "3", :French "3", :Sax-Swiss "III", :British-Tech "3", :British-Adj "D", :Nordic-Fin "2/3", :Nordic-Swe/Nor "2/3", :FB-Grade "1/2", :V-Grade "VB-", :Kurtyki "II+"}
                               "5.3" {:UIAA "4", :French "4", :Sax-Swiss "IV", :British-Tech "4a", :British-Adj "D/VD", :Nordic-Fin "3", :Nordic-Swe/Nor "3", :FB-Grade "2", :V-Grade "VB-", :Kurtyki "IV"}
                               "5.4" {:UIAA "4+", :French "4+", :Sax-Swiss "IV/V", :British-Tech "4a", :British-Adj "VD", :Nordic-Fin "4", :Nordic-Swe/Nor "4", :FB-Grade "2", :V-Grade "VB-", :Kurtyki "IV+"}
                               "5.5" {:UIAA "5-", :French "5a", :Sax-Swiss "V", :British-Tech "4a/4b", :British-Adj "S", :Nordic-Fin "5-", :Nordic-Swe/Nor "5-", :FB-Grade "3", :V-Grade "VB-/VB", :Kurtyki "V-"}
                               "5.6" {:UIAA "5", :French "5a", :Sax-Swiss "VI", :British-Tech "4b", :British-Adj "HS", :Nordic-Fin "5", :Nordic-Swe/Nor "5", :FB-Grade "3", :V-Grade "VB", :Kurtyki "V"}
                               "5.7" {:UIAA "5+", :French "5b", :Sax-Swiss "VI/VIIa", :British-Tech "4c", :British-Adj "HS/VS", :Nordic-Fin "5/5+", :Nordic-Swe/Nor "5/5+", :FB-Grade "4a", :V-Grade "VB/V0-", :Kurtyki "V+"}
                               "5.8" {:UIAA "6-", :French "5b", :Sax-Swiss "VIIa", :British-Tech "4c/5a", :British-Adj "VS", :Nordic-Fin "5+", :Nordic-Swe/Nor "5+", :FB-Grade "4a/4b", :V-Grade "V0-", :Kurtyki "V+/VI-"}
                               "5.9" {:UIAA "6", :French "5c", :Sax-Swiss "VIIb", :British-Tech "5a", :British-Adj "HVS", :Nordic-Fin "5+/6-", :Nordic-Swe/Nor "6-", :FB-Grade "4b", :V-Grade "V0-/V0", :Kurtyki "VI-"}
                               "5.10a" {:UIAA "6+", :French "6a", :Sax-Swiss "VIIc", :British-Tech "5a /5b", :British-Adj "E1", :Nordic-Fin "6-", :Nordic-Swe/Nor "6-/6", :FB-Grade "4c", :V-Grade "V0", :Kurtyki "VI-"}
                               "5.10b" {:UIAA "7-", :French "6a+", :Sax-Swiss "VIIIa", :British-Tech "5b", :British-Adj "E1/E2", :Nordic-Fin "6-/6", :Nordic-Swe/Nor "6", :FB-Grade "5a", :V-Grade "V0+", :Kurtyki "VI+"}
                               "5.10c" {:UIAA "7", :French "6b", :Sax-Swiss "VIIIb", :British-Tech "5b /5c", :British-Adj "E2", :Nordic-Fin "6", :Nordic-Swe/Nor "6+", :FB-Grade "5b", :V-Grade "V1", :Kurtyki "VI.1"}
                               "5.10d" {:UIAA "7+", :French "6b+", :Sax-Swiss "VIIIc", :British-Tech "5c", :British-Adj "E2/E3", :Nordic-Fin "6/6+", :Nordic-Swe/Nor "7-", :FB-Grade "5c", :V-Grade "V1/V2", :Kurtyki "VI.1+"}
                               "5.11a" {:UIAA "7+/8-", :French "6c", :Sax-Swiss "VIIIc/IXa", :British-Tech "5c", :British-Adj "E3", :Nordic-Fin "6+", :Nordic-Swe/Nor "7-/7", :FB-Grade "6a", :V-Grade "V2", :Kurtyki "VI.2"}
                               "5.11b" {:UIAA "8-", :French "6c+", :Sax-Swiss "IXa", :British-Tech "5c/6a", :British-Adj "E3/E4", :Nordic-Fin "6+/7-", :Nordic-Swe/Nor "7", :FB-Grade "6a+", :V-Grade "V2/V3", :Kurtyki "VI.2+"}
                               "5.11c" {:UIAA "8", :French "7a", :Sax-Swiss "IXb", :British-Tech "6a", :British-Adj "E4", :Nordic-Fin "7-", :Nordic-Swe/Nor "7+", :FB-Grade "6b", :V-Grade "V3", :Kurtyki "VI.2+/VI.3"}
                               "5.11d" {:UIAA "8+", :French "7a+", :Sax-Swiss "IXc", :British-Tech "6a", :British-Adj "E4/E5", :Nordic-Fin "7", :Nordic-Swe/Nor "7+/8-", :FB-Grade "6b+", :V-Grade "V3/V4", :Kurtyki "VI.3"}
                               "5.12a" {:UIAA "8+/9-", :French "7b", :Sax-Swiss "Ixc/Xa", :British-Tech "6a/6b", :British-Adj "E5", :Nordic-Fin "7+", :Nordic-Swe/Nor "8-", :FB-Grade "6b+/6c", :V-Grade "V4", :Kurtyki "VI.3+"}
                               "5.12b" {:UIAA "9-", :French "7b+", :Sax-Swiss "Xa", :British-Tech "6b", :British-Adj "E5/E6", :Nordic-Fin "8-", :Nordic-Swe/Nor "8-/8", :FB-Grade "6c", :V-Grade "V4", :Kurtyki "VI.4"}
                               "5.12c" {:UIAA "9", :French "7c", :Sax-Swiss "Xb", :British-Tech "6b / 6c", :British-Adj "E6", :Nordic-Fin "8", :Nordic-Swe/Nor "8", :FB-Grade "6c+", :V-Grade "V4/V5", :Kurtyki "VI.4+"}
                               "5.12d" {:UIAA "9+", :French "7c+", :Sax-Swiss "Xc", :British-Tech "6c", :British-Adj "E6/E7", :Nordic-Fin "8+", :Nordic-Swe/Nor "8/8+", :FB-Grade "7a", :V-Grade "V5", :Kurtyki "VI.4+/VI.5"}
                               "5.13a" {:UIAA "9+/10-", :French "8a", :Sax-Swiss "Xc", :British-Tech "6c", :British-Adj "E7", :Nordic-Fin "9-", :Nordic-Swe/Nor "8+", :FB-Grade "7a+", :V-Grade "V6", :Kurtyki "VI.5"}
                               "5.13b" {:UIAA "10-", :French "8a/8a+", :Sax-Swiss "Xc/XIa", :British-Tech "6c/7a", :British-Adj "E7/E8", :Nordic-Fin "9", :Nordic-Swe/Nor "9-", :FB-Grade "7a+/7b", :V-Grade "V6/V7", :Kurtyki "VI.5+"}
                               "5.13c" {:UIAA "10-", :French "8a+", :Sax-Swiss "XIa", :British-Tech "7a", :British-Adj "E8", :Nordic-Fin "9+", :Nordic-Swe/Nor "9-", :FB-Grade "7b", :V-Grade "V7", :Kurtyki "VI.4+/VI.6"}
                               "5.13d" {:UIAA "10", :French "8b", :Sax-Swiss "XIb", :British-Tech "7a", :British-Adj "E9", :Nordic-Fin "10-", :Nordic-Swe/Nor "9", :FB-Grade "7b+", :V-Grade "V8", :Kurtyki "VI.6"}
                               "5.14a" {:UIAA "10+", :French "8b+", :Sax-Swiss "XIc", :British-Tech "7a/7b", :British-Adj "E9/E10", :Nordic-Fin "10", :Nordic-Swe/Nor "9/9+", :FB-Grade "7c", :V-Grade "V9", :Kurtyki "VI.6+"}
                               "5.14b" {:UIAA "10+/11-", :French "8c", :Sax-Swiss "XIc/XIIa", :British-Tech "7b", :British-Adj "E10", :Nordic-Fin "10+", :Nordic-Swe/Nor "9+", :FB-Grade "7c+", :V-Grade "V10", :Kurtyki "VI.7"}
                               "5.14c" {:UIAA "11-", :French "8c+", :Sax-Swiss "XIIa", :British-Tech "7b", :British-Adj "E11", :Nordic-Fin "11-", :Nordic-Swe/Nor "9+", :FB-Grade "7c+/8a", :V-Grade "V10/V11", :Kurtyki "VI.7+"}
                               "5.14d" {:UIAA "11", :French "9a", :Sax-Swiss "XIIb", :British-Tech "7b", :British-Adj "E11", :Nordic-Fin "11", :Nordic-Swe/Nor "> 9+", :FB-Grade "8a", :V-Grade "V11", :Kurtyki "VI.8"}
                               "5.14d/5.15a" {:UIAA "11", :French "9a/9a+", :Sax-Swiss "XIIb", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "11 /11+", :Nordic-Swe/Nor "> 9+", :FB-Grade "8a+", :V-Grade "V12", :Kurtyki "VI.8+"}
                               "5.15a" {:UIAA "11/11+", :French "9a+", :Sax-Swiss "XIIb/XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "11+", :Nordic-Swe/Nor "> 9+", :FB-Grade "8a+/8b", :V-Grade "V12/V13", :Kurtyki "VI.8+"}
                               "5.15a/5.15b" {:UIAA "11+", :French "9a+/9b", :Sax-Swiss "XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe/Nor "> 9+", :FB-Grade "8b", :V-Grade "V13", :Kurtyki "VI.9(?)"}
                               "5.15b" {:UIAA "11+/12-", :French "9b", :Sax-Swiss "XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe/Nor "> 9+", :FB-Grade "8b+", :V-Grade "V14", :Kurtyki "VI.9(?)"}
                               "5.15c" {:UIAA "12-", :French "9b+", :Sax-Swiss "> XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe/Nor "> 9+", :FB-Grade "8c", :V-Grade "V15", :Kurtyki "VI.9(?)"}
                               "5.15d" {:UIAA "12", :French "9c", :Sax-Swiss "> XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe/Nor "> 9+", :FB-Grade "8c+", :V-Grade "V16", :Kurtyki "VI.9(?)"}))

(defn background-color-scale [n]
  (let [ratio (/ n 36.0)
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
   

(defn font-color-scale [n]
  (let [ratio (/ n 36.0)]

    (if (< ratio 0.75)
      "#000000"
      "#ffffff")))
  

(def yosemite-grades (keys grades-mapping))

(def yosemite-grades-to-index (zipmap yosemite-grades (range)))


(defn render-enter-grade-form [] 
  [
   :form {:class "grid"}
   [:input {:type "text" :id "grade" :name "grade"}]
   [:button {:type "submit"} "Submit"]])
   

(defn render-all-grades-table []
  [:table {:class "grades-table"}
   [:thead
    [:tr
     [:th "YDS"]
     [:th "French"]
     [:th "UIAA"]
     [:th "Fontainebleau"]
     [:th "V"]]]
   [:tbody
    (map (fn [yosemite-grade]
           (let [grade-index (get yosemite-grades-to-index yosemite-grade)]
             [:tr {:key yosemite-grade :style {:background-color (background-color-scale grade-index) :color (font-color-scale grade-index)}}
              [:td yosemite-grade]
              [:td (get (get grades-mapping yosemite-grade) :French)]
              [:td (get (get grades-mapping yosemite-grade) :UIAA)]
              [:td (get (get grades-mapping yosemite-grade) :FB-Grade)]
              [:td (get (get grades-mapping yosemite-grade) :V-Grade)]]))
         yosemite-grades)]])

(defn render-sport-grades-table []
  [:table {:class "grades-table"}
   [:thead
    [:tr
     [:th "YDS"]
     [:th "French"]
     [:th "UIAA"]
     ]]
   [:tbody
    (map (fn [yosemite-grade]
           (let [grade-index (get yosemite-grades-to-index yosemite-grade)]
             [:tr {:key yosemite-grade :style {:background-color (background-color-scale grade-index) :color (font-color-scale grade-index)}}
              [:td yosemite-grade]
              [:td (get (get grades-mapping yosemite-grade) :French)]
              [:td (get (get grades-mapping yosemite-grade) :UIAA)]]))
         yosemite-grades)]])

(defn render-bouldering-grades-table []
  [:table {:class "grades-table"}
   [:thead
    [:tr
     [:th "Fontainebleau"]
     [:th "V"]]]
   [:tbody
    (map (fn [yosemite-grade]
           (let [grade-index (get yosemite-grades-to-index yosemite-grade)]
             [:tr {:key yosemite-grade :style {:background-color (background-color-scale grade-index) :color (font-color-scale grade-index)}}
              [:td (get (get grades-mapping yosemite-grade) :FB-Grade)]
              [:td (get (get grades-mapping yosemite-grade) :V-Grade)]]))
         yosemite-grades)]])

(def tabs {
           :bouldering-grades ::bouldering-grades 
           :sport-grades ::sport-grades 
           :all-grades ::all-grades})

(def current-tab (rcore/atom (:bouldering-grades tabs)))

(defn render-nav-item [tab-name tab-id]
  (js/console.log tab-id)
  (js/console.log @current-tab)
  [:li {:class (if (= @current-tab tab-id) "active" "")} [:a { :href "#" :onClick (fn [] (swap! current-tab (fn [_] tab-id)))} tab-name]])

(defn render []
  [:div
  ;;  (render-enter-grade-form)
   [:nav {:role "tab-control" :class "nav-tabs"}
    [:ul
     (render-nav-item "Bouldering" (:bouldering-grades tabs))
     (render-nav-item "Sport" (:sport-grades tabs))
     (render-nav-item "All" (:all-grades tabs))
     ]]
   [:div {:role "tabs"}
    (case @current-tab
      ((:bouldering-grades tabs)) (render-bouldering-grades-table)
      ((:sport-grades tabs)) (render-sport-grades-table)
      ((:all-grades tabs)) (render-all-grades-table))
    ]])
   

(defn init []
  (start)
  (r/render
    [render]
    (.getElementById js/document "root")))
  


