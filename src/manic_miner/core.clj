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

(def manic-miner-room
  "Description d'une chambre de manic miner"
  (b/ordered-map
    :screen-layout (byte-list 512)
    :room-name (b/string "US-ASCII" :length 32)
    :the-rest (byte-list 480)
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

(let [decoded (decode-manic manic-miner-filename)
      room-names-list (map :room-name (:rooms decoded))]
  (doall
    (map (comp println s/trim) room-names-list))
)


