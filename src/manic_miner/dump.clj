
(ns manic-miner.dump
  (:require [clojure.java.io :as io])
  (:require [byte-streams])
  )

(def manic-miner-filename (io/resource "manic_miner.tzx"))

(def raw-data (byte-streams/to-byte-array (io/as-file manic-miner-filename)))
