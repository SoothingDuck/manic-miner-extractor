
(ns manic-miner.dump
  (:require [clojure.java.io :as io])
  )

(def manic-miner-filename (io/resource "manic_miner.tzx"))

(defn raw-data
  "Les données du fichier .tzx au format binaire"
  []
  (let [manic-file manic-miner-filename
        file->bytes (fn [path]
                      (with-open [in (io/input-stream path)
                                  out (java.io.ByteArrayOutputStream.)]
                        (io/copy in out)
                        (.toByteArray out)))
        ]
    (vec (file->bytes manic-file))
    ))

