(ns manic-miner.block
  (:require
   [org.clojars.smee.binary.core :as b]
   [manic-miner.tools :as tools]
   [mikera.image.core :as c]
   [mikera.image.colours :as colour]
   [clojure.pprint :refer (cl-format)]
   [clojure.string :as s]

   )
  )

(def graphic
  "Element d'affichage"
  (b/ordered-map
   :colour-attribute :byte
   :pixel-pattern (b/repeated :byte :length 8)
   )
  )

(defn pixel-mapping
  "Renvoie la cartographie du bloc"
  [block]
  (into [] (map tools/convert-number-to-bitvector (:pixel-pattern block)))
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

(defn show
  "Affiche le bloc"
  [block]

  (let [bi (c/new-image 8 8 false)
        mapping (pixel-mapping block)
        ]

    (doseq [x (range 8)
            y (range 8)]
      (when (get-in mapping [y x])
        (c/set-pixel bi x y colour/red)

        )
        )
    ;; fill some random pixels with colours
    ;; (dotimes [i 1024]
    ;;   (aset pixels i (colour/yellow)))

    ;; update the image with the newly changed pixel values

    ;; view our new work of art
    ;; the zoom function will automatically interpolate the pixel values
    (c/show bi :zoom 10.0 :title "Isn't it beautiful?")
    )

  )
