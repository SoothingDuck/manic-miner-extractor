(ns manic-miner.block
  (:require
   [org.clojars.smee.binary.core :as b]
   [mikera.image.core :as c]
   [mikera.image.colours :as colour]
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

(defn layout
  "Plot ascii layout of pixel pattern"
  [block]

  (let [bi (c/new-image 8 8)
        la (layout-ascii block)
        flatla (-> la (s/replace "\n" ""))
        pixels (c/get-pixels bi)
        ]
    (doseq [x (map vector flatla (range 64))]
      (let [c (first x)
            i (second x)]
        (if (= c \space)
          (aset pixels i 255)
          (aset pixels i 0)
          )
        )
      )
    (c/set-pixels bi pixels)
    bi
    )
  )

;; create a new image
(def bi (c/new-image 32 32))

;; gets the pixels of the image, as an int array
(def pixels (c/get-pixels bi))

;; fill some random pixels with colours
(dotimes [i 1024]
  (aset pixels i (colour/rand-colour)))

;; update the image with the newly changed pixel values
(c/set-pixels bi pixels)

;; view our new work of art
;; the zoom function will automatically interpolate the pixel values
;; (c/show bi :zoom 10.0 :title "Isn't it beautiful?")
