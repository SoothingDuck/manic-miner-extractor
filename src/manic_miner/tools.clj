(ns manic-miner.tools
  (:require
   [org.clojars.smee.binary.core :as b]
   [clojure.pprint :refer (cl-format)]
   )
  )

(defn byte-list [len]
  (b/repeated :byte :length len))

(defn convert-number-to-bitvector
  "Converti un nombre en sa séquence de bits"
  [number]
  (let [convert-to-bit #(cl-format nil "~8,'0B" (bit-and % 0xff))
        bit-map (convert-to-bit number)
        ]
    (into (vector) (map #(= \1 %) bit-map))))
