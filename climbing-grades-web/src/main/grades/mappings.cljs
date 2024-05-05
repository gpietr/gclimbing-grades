(ns grades.mappings)

(def sport-grades-mapping (array-map "5.0" {:UIAA "I", :French "1", :Sax-Swiss "I", :British-Tech "1", :British-Adj "M", :Nordic-Fin "1", :Nordic-Swe-Nor "1", :Kurtyki "I", :Australian "10"}
                                     "5.1" {:UIAA "II", :French "2", :Sax-Swiss "II", :British-Tech "2", :British-Adj "M/D", :Nordic-Fin "2", :Nordic-Swe-Nor "2", :Kurtyki "II", :Australian "11"}
                                     "5.2" {:UIAA "III", :French "3", :Sax-Swiss "III", :British-Tech "3", :British-Adj "D", :Nordic-Fin "2/3", :Nordic-Swe-Nor "2/3", :Kurtyki "II+", :Australian "12"}
                                     "5.3" {:UIAA "IV", :French "4", :Sax-Swiss "IV", :British-Tech "4a", :British-Adj "D/VD", :Nordic-Fin "3", :Nordic-Swe-Nor "3", :Kurtyki "IV", :Australian "13"}
                                     "5.4" {:UIAA "IV+", :French "4+", :Sax-Swiss "IV/V", :British-Tech "4a", :British-Adj "VD", :Nordic-Fin "4", :Nordic-Swe-Nor "4", :Kurtyki "IV+", :Australian "14"}
                                     "5.5" {:UIAA "V-", :French "5a", :Sax-Swiss "V", :British-Tech "4a/4b", :British-Adj "S", :Nordic-Fin "5-", :Nordic-Swe-Nor "5-", :Kurtyki "V-", :Australian "15"}
                                     "5.6" {:UIAA "V", :French "5a", :Sax-Swiss "VI", :British-Tech "4b", :British-Adj "HS", :Nordic-Fin "5", :Nordic-Swe-Nor "5", :Kurtyki "V", :Australian "16"}
                                     "5.7" {:UIAA "V+", :French "5b", :Sax-Swiss "VI/VIIa", :British-Tech "4c", :British-Adj "HS/VS", :Nordic-Fin "5/5+", :Nordic-Swe-Nor "5/5+", :Kurtyki "V+", :Australian "17"}
                                     "5.8" {:UIAA "VI-", :French "5b", :Sax-Swiss "VIIa", :British-Tech "4c/5a", :British-Adj "VS", :Nordic-Fin "5+", :Nordic-Swe-Nor "5+", :Kurtyki "V+/VI-", :Australian "18"}
                                     "5.9" {:UIAA "VI", :French "5c", :Sax-Swiss "VIIb", :British-Tech "5a", :British-Adj "HVS", :Nordic-Fin "5+/6-", :Nordic-Swe-Nor "6-", :Kurtyki "VI-", :Australian "19"}
                                     "5.10a" {:UIAA "VI+", :French "6a", :Sax-Swiss "VIIc", :British-Tech "5a /5b", :British-Adj "E1", :Nordic-Fin "6-", :Nordic-Swe-Nor "6-/6", :Kurtyki "VI-", :Australian "20"}
                                     "5.10b" {:UIAA "VII-", :French "6a+", :Sax-Swiss "VIIIa", :British-Tech "5b", :British-Adj "E1/E2", :Nordic-Fin "6-/6", :Nordic-Swe-Nor "6", :Kurtyki "VI+", :Australian "21"}
                                     "5.10c" {:UIAA "VII", :French "6b", :Sax-Swiss "VIIIb", :British-Tech "5b /5c", :British-Adj "E2", :Nordic-Fin "6", :Nordic-Swe-Nor "6+", :Kurtyki "VI.1", :Australian "22"}
                                     "5.10d" {:UIAA "VII+", :French "6b+", :Sax-Swiss "VIIIc", :British-Tech "5c", :British-Adj "E2/E3", :Nordic-Fin "6/6+", :Nordic-Swe-Nor "7-", :Kurtyki "VI.1+", :Australian "23"}
                                     "5.11a" {:UIAA "VII+/VIII-", :French "6c", :Sax-Swiss "VIIIc/IXa", :British-Tech "5c", :British-Adj "E3", :Nordic-Fin "6+", :Nordic-Swe-Nor "7-/7", :Kurtyki "VI.2", :Australian "24"}
                                     "5.11b" {:UIAA "VIII-", :French "6c+", :Sax-Swiss "IXa", :British-Tech "5c/6a", :British-Adj "E3/E4", :Nordic-Fin "6+/7-", :Nordic-Swe-Nor "7", :Kurtyki "VI.2+", :Australian "25"}
                                     "5.11c" {:UIAA "VIII", :French "7a", :Sax-Swiss "IXb", :British-Tech "6a", :British-Adj "E4", :Nordic-Fin "7-", :Nordic-Swe-Nor "7+", :Kurtyki "VI.2+/VI.3", :Australian "26"}
                                     "5.11d" {:UIAA "VIII+", :French "7a+", :Sax-Swiss "IXc", :British-Tech "6a", :British-Adj "E4/E5", :Nordic-Fin "7", :Nordic-Swe-Nor "7+/8-", :Kurtyki "VI.3", :Australian "26"}
                                     "5.12a" {:UIAA "VIII+/IX-", :French "7b", :Sax-Swiss "Ixc/Xa", :British-Tech "6a/6b", :British-Adj "E5", :Nordic-Fin "7+", :Nordic-Swe-Nor "8-", :Kurtyki "VI.3+", :Australian "26"}
                                     "5.12b" {:UIAA "IX-", :French "7b+", :Sax-Swiss "Xa", :British-Tech "6b", :British-Adj "E5/E6", :Nordic-Fin "8-", :Nordic-Swe-Nor "8-/8", :Kurtyki "VI.4", :Australian "27"}
                                     "5.12c" {:UIAA "IX", :French "7c", :Sax-Swiss "Xb", :British-Tech "6b / 6c", :British-Adj "E6", :Nordic-Fin "8", :Nordic-Swe-Nor "8", :Kurtyki "VI.4+", :Australian "28"}
                                     "5.12d" {:UIAA "IX+", :French "7c+", :Sax-Swiss "Xc", :British-Tech "6c", :British-Adj "E6/E7", :Nordic-Fin "8+", :Nordic-Swe-Nor "8/8+", :Kurtyki "VI.4+/VI.5", :Australian "29"}
                                     "5.13a" {:UIAA "IX+/X-", :French "8a", :Sax-Swiss "Xc", :British-Tech "6c", :British-Adj "E7", :Nordic-Fin "9-", :Nordic-Swe-Nor "8+", :Kurtyki "VI.5", :Australian "29"}
                                     "5.13b" {:UIAA "X-", :French "8a/8a+", :Sax-Swiss "Xc/XIa", :British-Tech "6c/7a", :British-Adj "E7/E8", :Nordic-Fin "9", :Nordic-Swe-Nor "9-", :Kurtyki "VI.5+", :Australian "30"}
                                     "5.13c" {:UIAA "X-", :French "8a+", :Sax-Swiss "XIa", :British-Tech "7a", :British-Adj "E8", :Nordic-Fin "9+", :Nordic-Swe-Nor "9-", :Kurtyki "VI.4+/VI.6", :Australian "30"}
                                     "5.13d" {:UIAA "X", :French "8b", :Sax-Swiss "XIb", :British-Tech "7a", :British-Adj "E9", :Nordic-Fin "10-", :Nordic-Swe-Nor "9", :Kurtyki "VI.6", :Australian "31"}
                                     "5.14a" {:UIAA "X+", :French "8b+", :Sax-Swiss "XIc", :British-Tech "7a/7b", :British-Adj "E9/E10", :Nordic-Fin "10", :Nordic-Swe-Nor "9/9+", :Kurtyki "VI.6+", :Australian "32"}
                                     "5.14b" {:UIAA "X+/XI-", :French "8c", :Sax-Swiss "XIc/XIIa", :British-Tech "7b", :British-Adj "E10", :Nordic-Fin "10+", :Nordic-Swe-Nor "9+", :Kurtyki "VI.7", :Australian "33"}
                                     "5.14c" {:UIAA "XI-", :French "8c+", :Sax-Swiss "XIIa", :British-Tech "7b", :British-Adj "E11", :Nordic-Fin "11-", :Nordic-Swe-Nor "9+", :Kurtyki "VI.7+", :Australian "34"}
                                     "5.14d" {:UIAA "XI", :French "9a", :Sax-Swiss "XIIb", :British-Tech "7b", :British-Adj "E11", :Nordic-Fin "11", :Nordic-Swe-Nor "> 9+", :Kurtyki "VI.8", :Australian "35"}
                                     "5.14d/5.15a" {:UIAA "XI", :French "9a/9a+", :Sax-Swiss "XIIb", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "11 /11+", :Nordic-Swe-Nor "> 9+", :Kurtyki "VI.8+", :Australian "35"}
                                     "5.15a" {:UIAA "XI+", :French "9a+", :Sax-Swiss "XIIb/XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "11+", :Nordic-Swe-Nor "> 9+", :Kurtyki "VI.8+", :Australian "36"}
                                     "5.15a/5.15b" {:UIAA "XI+", :French "9a+/9b", :Sax-Swiss "XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe-Nor "> 9+", :Kurtyki "VI.9(?)", :Australian "36"}
                                     "5.15b" {:UIAA "XII-", :French "9b", :Sax-Swiss "XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe-Nor "> 9+", :Kurtyki "VI.9(?)", :Australian "37"}
                                     "5.15c" {:UIAA "XII", :French "9b+", :Sax-Swiss "> XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe-Nor "> 9+", :Kurtyki "VI.9(?)", :Australian "38"}
                                     "5.15d" {:UIAA "XII+", :French "9c", :Sax-Swiss "> XIIc", :British-Tech "> 7b", :British-Adj "> E11", :Nordic-Fin "> 11+", :Nordic-Swe-Nor "> 9+", :Kurtyki "VI.9(?)", :Australian "39"}
))
                                     
(def bouldering-grades-mapping (array-map
                                "VB" {:FB-Grade "3"}
                                "V0" {:FB-Grade "4"}
                                "V1" {:FB-Grade "5a/5b"}
                                "V2" {:FB-Grade "5c"}
                                "V3" {:FB-Grade "6a/6a+"}
                                "V4" {:FB-Grade "6b/6b+"}
                                "V5" {:FB-Grade "6c/6c+"}
                                "V6" {:FB-Grade "7a"}
                                "V7" {:FB-Grade "7a+"}
                                "V8" {:FB-Grade "7b/7b+"}
                                "V9" {:FB-Grade "7c"}
                                "V10" {:FB-Grade "7c+"}
                                "V11" {:FB-Grade "8a"}
                                "V12" {:FB-Grade "8a+"}
                                "V13" {:FB-Grade "8b"}
                                "V14" {:FB-Grade "8b+"}
                                "V15" {:FB-Grade "8c"}
                                "V16" {:FB-Grade "8c+"}
                                "V17" {:FB-Grade "9a"}))

(def mixed-grades-descriptions [{:grade "M1"  :description "Feels like 5.5 climbing."}
                                {:grade "M2"  :description "Feels like 5.6 climbing."}
                                {:grade "M3"  :description "Feels like 5.7 climbing."}
                                {:grade "M4"  :description "Feels like 5.8 climbing."}
                                {:grade "M5"  :description "Feels like 5.9 climbing; using the blades of ice axes in cracks to torque and dry-hook is useful."}
                                {:grade "M6"  :description "Feels like 5.9+ climbing; using the blades of ice axes in cracks to torque and dry-hook is mandatory."}
                                {:grade "M7"  :description "Feels like 5.10 climbing; using ice axes and crampons in such a way as to make the climb impossible without them. Usually somewhat overhanging."}
                                {:grade "M8"  :description "Feels like 5.11 climbing; using ice axes and crampons in such a way as to make the climb impossible without them. Involves overhanging and sustained climbing."}
                                {:grade "M9"  :description "Feels like 5.11+ climbing, using ice axes and crampons in such a way as to make the climb impossible without them. Involves severely sustained and extremely overhanging climbing."}
                                {:grade "M10" :description "Feels like 5.12 climbing"}
                                {:grade "M11" :description "Feels like 5.12+ climbing"}
                                {:grade "M12" :description "Feels like 5.13 climbing"}
                                {:grade "M13" :description "Feels like 5.13+ climbing"}
                                {:grade "M14" :description "Feels like  5.14 climbing"}
                                {:grade "M15" :description "Feels like 5.14+ climbing"}
                                {:grade "M16" :description "Feels like 5.15 climbing"}])


(def ice-grades-descriptions [{:grade "WI 1" :description "Easy, low-angled ice. Walking up ice where crampons are necessary. The easiest ice for which a belay rope would be used. A basic level of technical expertise for safety is required. General angle: 50 degrees."}
                              {:grade "WI 2" :description "Moderate, low-angled water ice with short bulges. Good protection and anchors. Front-points of the crampons may or may not be required. General angle: 60 degrees."}
                              {:grade "WI 3" :description "Steeper water ice, with longer bulges. Some continuous front pointing but with good resting places between. Generally good protection, screws can be placed from comfortable stances. The ice is usually of good quality. Requires adeptness at placing protection and making belays. General angle: 70 degrees."}
                              {:grade "WI 4" :description "Sustained climbing with some vertical sections, separated by good belays. The ice may have some technical features like chandeliers but generally the quality of ice is good and offers secure protection and belays. Usually demands that screws be placed while on vertical or near vertical ice. General angle: 80 degrees."}
                              {:grade "WI 5" :description "A long, steep, strenuous, columnar pitch of ice. Sustained difficulties with little opportunity to rest. Expertise in dealing with the different ice formations is required (e.g., chandeliers, cauliflowers, candled sections). Adequate protection requires effort to place. The climb may sometimes be run-out above protection. Belays may be difficult to create and/or hanging. General angle: 90 degrees."}
                              {:grade "WI 6" :description "A serious lead on severe and/or thin ice. Long vertical and/or overhanging sections, extremely sustained difficulties. Few, if any, resting sites. Ice may not be of the best quality, often thin, chandeliered and hard to protect. Expert technique and a powerful, positive mind frame are prerequisites. Hanging belays of dubious quality may be required. General angle: 90+ degrees."}
                              {:grade "WI 7" :description "Ice that is very thin, long, overhanging or very technical. Free-hanging columns of dubious adhesion. This grade requires creative techniques to climb and to find protection. Protection may be non-existent. A very physical and emotional pitch. Total commitment is required. Belays require a very high level of expertise, and may be marginal at best. This grade applies to only a handful of routes led by an even fewer number of world class climbers. WI 7 is the outer space of ice climbing. General angle: 90++ degrees."}])

(def aid-grades-descriptions [{:grade "A1"  :description "Easy aid. No risk of a piece pulling out"}
                              {:grade "A2"  :description "Moderate aid. Solid gear that's more difficult to place"}
                              {:grade "A2+" :description  "10-meter fall potential from tenuous placements, but without danger"}
                              {:grade "A3"  :description "Hard aid. Many tenuous placements in a row, 15-meter fall potential, could require several hours for a single pitch"}
                              {:grade "A3+" :description  "A3 with dangerous fall potential"}
                              {:grade "A4"  :description "Serious aid. 30-meter ledge-fall potential from continuously tenuous gear"}
                              {:grade "A4+" :description  "Even more serious, with even greater fall potential, where each pitch could take many hours to lead"}
                              {:grade "A5"  :description "Extreme aid. Nothing on the entire pitch can be trusted to hold a fall"}
                              {:grade "A6"  :description "A5 climbing with belay anchors that won't hold a fall either"}])