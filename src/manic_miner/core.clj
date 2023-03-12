(ns manic-miner.core
  (:require
   [manic-miner.file :as file]
   [manic-miner.block :as block]
   [mikera.image.core :as c]
   [manic-miner.room :as room]
   [manic-miner.tools :as tools])
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )

(def first-nasty (second (room/room-nasties file/central-cavern)))

;;; Afficher le mapping
(prn (block/pixel-mapping first-nasty))

(block/show first-nasty)
