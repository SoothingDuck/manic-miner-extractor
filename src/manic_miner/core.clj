(ns manic-miner.core
  (:require
   [manic-miner.file :as file]
   [manic-miner.block :as block]
   [manic-miner.room :as room]
   [manic-miner.colour :as colour]
   [clojure.string :as str])
  (:gen-class))

;; https://www.icemark.com/dataformats/manic/mmformat.htm

;; Central Cavern Brick Wall
(let [central-cavern-room (-> file/room-list first)
      central-cavern-wall (-> central-cavern-room :elements :wall)
      ]
  central-cavern-wall
)

;; https://stackoverflow.com/questions/6973290/generate-and-save-a-png-image-in-clojure
;; https://github.com/Serabe/rinzelight

(first file/room-list)

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _])

