(ns manic-miner.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [manic-miner.dump :as dump])
  )


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (byte-streams/print-bytes dump/raw-data)
  )
