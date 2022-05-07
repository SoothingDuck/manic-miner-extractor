(ns manic-miner.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [manic-miner.dump :as dump])
  )


(def data-file (io/resource 
                   "manic_miner.tzx" ))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (dump/raw-data))
  )
