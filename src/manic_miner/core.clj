(ns manic-miner.core
  (:require
   [manic-miner.file :as file]
   [manic-miner.block :as block]
   [mikera.image.core :as c])
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )


;; (print (room/layout-ascii (nth file/room-list 1)))

(prn (range 4))

(def bi (-> file/central-cavern
    :elements
    :nasty-1
    block/layout
    ))

(c/save bi "toto.png" :quality 0.9 :progressive true)
