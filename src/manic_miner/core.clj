(ns manic-miner.core
  (:gen-class)
  (:require [manic-miner.dump :as dump])
  (:require [manic-miner.const :as const])
  (:require [manic-miner.tools :as tools])
  (:require [manic-miner.room :as room])
  (:require [clojure.string :as string])
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  (map :name room/rooms)
 )
