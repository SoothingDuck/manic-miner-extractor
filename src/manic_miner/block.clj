(ns manic-miner.block
  (:require
   [org.clojars.smee.binary.core :as b]
   [clojure.string :as s]
   [clojure.pprint :refer (cl-format)]
   )
  )

(def graphic
  "Element d'affichage"
  (b/ordered-map
   :colour-attribute :byte
   :pixel-pattern (b/repeated :byte :length 8)
   )
  )

(defn layout-ascii
  "Plot ascii layout of pixel pattern"
  [block]

  (let [convert-to-bit #(cl-format nil "~8,'0B" (bit-and % 0xff))
        bit-map (map convert-to-bit (:pixel-pattern block))
        next-n (for [x bit-map] (str x "\n"))
        binary-str (apply str next-n)
        ]
    (->
     binary-str
     (s/replace "0" " ")
     (s/replace "1" "#")
     )
    )
  )
