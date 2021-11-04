(ns manic-miner.file
  (:require [clojure.java.io :as io]))

(defn manic-miner-filename
  "Le nom du fichier manic miner situé dans les resources"
  []
  (.getFile (io/resource "manic_miner.tzx")))

(defn manic-miner-raw-data
  "Les données du fichier .tzx au format binaire"
  []
  (let [manic-file (manic-miner-filename)
        file->bytes (fn [path]
                      (with-open [in (io/input-stream path)
                                  out (java.io.ByteArrayOutputStream.)]
                        (io/copy in out)
                        (.toByteArray out)))
        ]
    (vec (file->bytes manic-file))
    ))
