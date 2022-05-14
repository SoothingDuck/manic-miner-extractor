
(ns manic-miner.dump
  (:require [clojure.java.io :as io])
  ; (:require [byte-streams :as bytes])
  )

(def manic-miner-filename (io/resource "manic_miner.tzx"))

; (def raw-data (bytes/to-byte-array (io/as-file manic-miner-filename)))
