(ns manic-miner.core
  (:require [org.clojars.smee.binary.core :as b]
            [clojure.java.io :as io]
            [clojure.string :as s])
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )

(def manic-miner-filename 
  "Mon fichier"
  (io/resource "manic_miner.tzx"))


(defn byte-list [len]
  (b/repeated :byte :length len))


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
    :screen-layout (byte-list 512) ;; 0 to 511
    :room-name (b/string "US-ASCII" :length 32) ;; 512 to 543
    :block-graphics block-graphics ;; 72 - 544 to 615
    :miner-willy-start-position (byte-list 7) ;; 616 to 622
    :conveyor (byte-list 4) ;; 623 to 626
    :border-color :byte ;; 1 - 627
    :items (byte-list 27) ;; 628 to 654
    :portal (byte-list 37) ;; 655 to 691
    :item-graphic (byte-list 8) ;; 692 to 699
    :air (byte-list 2) ;; 700 to 701
    :horizontal-guardians (byte-list 31) ;; 702 to 732
    :vertical-guardians (byte-list 35) ;; 733 to 767
    :guardian-graphics (byte-list 256) ;; 768 to 1023
    )
  )

(def manic-miner-file
  "Description globale du fichier manic miner"
  (b/ordered-map
    :header-junk (byte-list (- 0x33b4 512))
    :rooms (b/repeated manic-miner-room :length 20)
    )
    
)  

(defn decode-manic 
  "Fonction pour décoder un fichier manic miner"
  [filename]
  (let [in (io/input-stream filename)]
    (b/decode manic-miner-file in)))


(def manic-miner-room-names
  "Extrait les noms des pièces"
  (let [decoded (decode-manic manic-miner-filename)
        room-names-list (map :room-name (:rooms decoded))]
    (map s/trim room-names-list)
    )
  )

(def central-cavern
  (let [decoded (decode-manic manic-miner-filename)]
    (first (:rooms decoded))
    ))

(def colour-set
  "Colour codes used for colour attributes"
  {
   2r000 :black
   2r001 :blue
   2r010 :red
   2r011 :magenta
   2r100 :green
   2r101 :cyan
   2r110 :yellow
   2r111 :white
   }
  )

(defn colour-attributes
  "Get colour attributes from screen layout"
  [byte-value]
  {
   :flash (bit-shift-right (bit-and byte-value 2r10000000) 7)
   :brightness (bit-shift-right (bit-and byte-value 2r01000000) 6)
   :paper-colour (get colour-set (bit-shift-right (bit-and byte-value 2r00111000) 3))
   :ink-colour (get colour-set (bit-shift-right (bit-and byte-value 2r00000111) 0))
   }
  )

(let [layout (:screen-layout central-cavern)
      node-list (map (comp :paper-colour colour-attributes) layout)
      ]
  (println node-list)
  )


