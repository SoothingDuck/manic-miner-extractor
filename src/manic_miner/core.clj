(ns manic-miner.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as s])
  (:require [manic-miner.const :as const])
  (:require [manic-miner.tools :as tools]))


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

(defn manic-miner-rooms-data
  "Les données de chaque pièce séparées dans un vecteur"
  []
  (let [raw-data (manic-miner-raw-data)
        offset-rooms (range const/MAGIC_OFFSET_CENTRAL_CAVERN const/MAGIC_OFFSET_LAST_CAVE 1024)]
    (map #(tools/slice-array raw-data % (+ % 1024)) offset-rooms)))

(nth (manic-miner-rooms-data) 1)


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
