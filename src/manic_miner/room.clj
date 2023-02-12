(ns manic-miner.room
  (:require
   [org.clojars.smee.binary.core :as b]
   [clojure.string :as s]
   [manic-miner.tools :as tools]
   [manic-miner.file :as file]
   )
  )

(def block-graphic
  "Element d'affichage"
  (b/ordered-map
   :colour-attribute :byte
   :pixel-pattern (b/repeated :byte :length 8)
   )
  )


(def block-graphics
  "Les block graphics pour le background"
  (b/ordered-map

   :background block-graphic
   :floor block-graphic
   :crumbling-floor block-graphic
   :wall block-graphic
   :conveyor block-graphic
   :nasty-1 block-graphic
   :nasty-2 block-graphic
   :spare block-graphic

   )
  )

(def manic-miner-room
  "Description d'une chambre de manic miner"
  (b/ordered-map
   :screen-layout (tools/byte-list 512) ;; 0 to 511
   :room-name (b/string "US-ASCII" :length 32) ;; 512 to 543
   :block-graphics block-graphics ;; 72 - 544 to 615
   :miner-willy-start-position (tools/byte-list 7) ;; 616 to 622
   :conveyor (tools/byte-list 4) ;; 623 to 626
   :border-color :byte ;; 1 - 627
   :items (tools/byte-list 27) ;; 628 to 654
   :portal (tools/byte-list 37) ;; 655 to 691
   :item-graphic (tools/byte-list 8) ;; 692 to 699
   :air (tools/byte-list 2) ;; 700 to 701
   :horizontal-guardians (tools/byte-list 31) ;; 702 to 732
   :vertical-guardians (tools/byte-list 35) ;; 733 to 767
   :guardian-graphics (tools/byte-list 256) ;; 768 to 1023
   )
  )

(def manic-miner-room-names
  "Extrait les noms des pièces"
  (let [decoded (file/decode file/manic-miner-filename)
        room-names-list (map :room-name (:rooms decoded))]
    (map s/trim room-names-list)
    )
  )

(def central-cavern
  (let [decoded (file/decode-manic file/manic-miner-filename)]
    (first (:rooms decoded))
    ))
