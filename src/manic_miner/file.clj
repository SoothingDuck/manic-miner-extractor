
(ns manic-miner.file
  (:require [clojure.java.io :as io])
  (:require [manic-miner.const :as const])
  (:require [manic-miner.tools :as tools])
  )

(defn manic-miner-filename
  "Le nom du fichier manic miner situé dans les resources"
  []
  (.getFile (io/resource "manic_miner.tzx")))

(defn raw-data
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

(defn room-data-list
  "Les données de chaque pièce séparées dans un vecteur"
  []
  (let [raw-data (raw-data)
        offset-rooms (range const/FILE_OFFSET_CENTRAL_CAVERN const/FILE_OFFSET_LAST_CAVE 1024)]
    (map #(tools/slice-array raw-data % (+ % 1024)) offset-rooms)))
