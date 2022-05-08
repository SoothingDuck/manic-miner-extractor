(ns manic-miner.tools
  (:require [clojure.java.io :as io])
)

(defn to-hex-string-byte
  "Conversion d'un byte en sa valeur hexadecimale"
  [b]
  (let [int_value (int b)]
    (Integer/toHexString int_value)))

(defn to-hex-string-array
  "Conversion d'un tableau de byte en un tableau de chaines hexadécimales"
  [a]
  (map to-hex-string-byte (seq a))
  )

(defn slice-array
  "Returns a manageable slice of an array"
  [arr begin end]
  (vec (subvec arr begin end)))

(defn file->bytes [path]
  (with-open [in (io/input-stream path)
              out (java.io.ByteArrayOutputStream.)]
    (io/copy in out)
    (.toByteArray out)))