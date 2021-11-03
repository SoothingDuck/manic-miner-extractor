(ns manic-miner.core
  (:gen-class)
  (:require [clojure.java.io :as io]))

(defn manic-miner-filename
  []
  (.getFile (io/resource "manic_miner.tzx"))
  )

(defn manic-miner-raw-data
  []
  (vec (slurp (manic-miner-filename))))

(subvec (manic-miner-raw-data) 0x22 0xFF)


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
