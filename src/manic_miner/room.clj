(ns manic-miner.room
  (:require
   [org.clojars.smee.binary.core :as b]
   [manic-miner.tools :as tools]
   [manic-miner.colour :as colour]
   [manic-miner.block :as block]
   )
  )


(def elements
  "Les block graphics pour le background"
  (b/ordered-map

   :background block/graphic
   :floor block/graphic
   :crumbling-floor block/graphic
   :wall block/graphic
   :conveyor block/graphic
   :nasty-1 block/graphic
   :nasty-2 block/graphic
   :spare block/graphic

   )
  )

(def manic-miner-room
  "Description d'une chambre de manic miner"
  (b/ordered-map
   :screen-layout (tools/byte-list 512) ;; 0 to 511
   :room-name (b/string "US-ASCII" :length 32) ;; 512 to 543
   :elements elements ;; 72 - 544 to 615
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

(defn room-nasties
  "Les méchants de la pièce"
  [room]
  [(-> room :elements :nasty-1) (-> room :elements :nasty-2)]
  )

(defn room-name
  "Le nom de la pièce"
  [room]
  (:room-name room)
  )

(defn layout-ascii
  "Renvoie une représentation ASCII de la pièce"
  [room]
  (let [layout (:screen-layout room)
        node-list (map (comp :ink-colour colour/attributes) layout)
        node-ascii-list (map #(if (= :black %) " " "#") node-list)
        node-split-32 (partition 32 node-ascii-list)
        ascii-list (for [x node-split-32] (let [y (apply str x)] (str y "\n")))
        ]
    (apply str ascii-list)
    )
  )
