(ns manic-miner.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as s]))

(def MAGIC_OFFSET_CENTRAL_CAVERN 0x33B4)
(def MAGIC_OFFSET_LAST_CAVE (+ MAGIC_OFFSET_CENTRAL_CAVERN (* 1024 20)))

(defn manic-miner-filename
  []
  (.getFile (io/resource "manic_miner.tzx"))
  )

(defn manic-miner-raw-data
  []
  (let [manic-file (manic-miner-filename)]
    (slurp (manic-miner-filename))
    )
  )

(defn file->bytes [path]
  (with-open [in (io/input-stream path)
              out (java.io.ByteArrayOutputStream.)]
    (io/copy in out)
    (.toByteArray out)))

(def manic-miner-bytes (vec (file->bytes (manic-miner-filename))))

(defn to-hex-string-byte
  [b]
  (let [int_value (int b)]

    (Integer/toHexString int_value)
    )
  )

(to-hex-string-byte (first manic-miner-bytes))

(map #(Integer/toHexString (int %)) (take 16 manic-miner-bytes))


(s/trim
 (apply
  str
  (map char
       (subvec manic-miner-bytes 0x33b4 (+ 0x33b4 32))
  )
 )

(defn manic-miner-rooms-data []
  (let [raw-data (manic-miner-raw-data)
        offset-rooms (range MAGIC_OFFSET_CENTRAL_CAVERN MAGIC_OFFSET_LAST_CAVE 1024)
        ]
    (subvec raw-data MAGIC_OFFSET_CENTRAL_CAVERN (+ MAGIC_OFFSET_CENTRAL_CAVERN 1024))
    )
  )

(+ 0x33B4 0)

(subvec (manic-miner-raw-data) 0x33b0 0x33d0)
(subvec (manic-miner-raw-data) MAGIC_OFFSET_CENTRAL_CAVERN)
(subvec (manic-miner-rooms-data) 512 (+ 512 32))
(subvec (manic-miner-rooms-data) 512 (+ 512 32))
(subvec (manic-miner-rooms-data) 512 (+ 512 32))
(take 1 (manic-miner-rooms-data))

(subvec (manic-miner-raw-data) 13248 13300)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
