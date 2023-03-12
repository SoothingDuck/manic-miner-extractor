(ns manic-miner.core
  (:require
   [manic-miner.file :as file]
   [manic-miner.block :as block]
   [manic-miner.room :as room])
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )

(def first-nasty (second (room/room-nasties file/central-cavern)))

;;; Afficher le mapping
;; (room/save-nasties file/central-cavern "DATA/central_cavern_")

(doseq [room file/room-list]
  (prn (room/formatted-room-name room))

  )
