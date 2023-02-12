(ns manic-miner.core
  (:require
   [manic-miner.file :as file]
   [manic-miner.colour :as colour]

   [manic-miner.room :as room])
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )


(print (room/layout-ascii (nth file/room-list 1)))
