(ns manic-miner.core
  (:require
    [manic-miner.file :as file]
    [manic-miner.block :as block])
  (:gen-class))

;; https://www.icemark.com/dataformats/manic/mmformat.htm

;; Element list
(let [central-cavern-room (-> file/room-list first)]
  (-> central-cavern-room :elements keys)
  )

;; (:background :floor :crumbling-floor :wall :conveyor :nasty-1 :nasty-2 :spare)

;; Central Cavern Brick Wall
(let [central-cavern-room (-> file/room-list first)
      central-cavern-wall (-> central-cavern-room :elements :crumbling-floor)
      wall-pixel-list (-> central-cavern-wall block/pixel-mapping)]
  (print "\n")
  (doseq [x wall-pixel-list]
    (doseq [y x]
      (if y (print "#") (print " "))
      )
    (print "\n")
    ))

;; https://stackoverflow.com/questions/6973290/generate-and-save-a-png-image-in-clojure
;; https://github.com/Serabe/rinzelight

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _])
