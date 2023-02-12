(ns manic-miner.file
  (:require
   [org.clojars.smee.binary.core :as b]
    [clojure.string :as s]
    [clojure.java.io :as io]
    [manic-miner.tools :as tool]
    [manic-miner.room :as room]
   )
  )

(def manic-miner-filename
  "Mon fichier"
  (io/resource "manic_miner.tzx"))

(def manic-miner-file
  "Description globale du fichier manic miner"
  (b/ordered-map
    :header-junk (tool/byte-list (- 0x33b4 512))
    :rooms (b/repeated room/manic-miner-room :length 20)
    )
  )

(defn decode
  "Fonction pour décoder un fichier manic miner"
  [filename]
  (let [in (io/input-stream filename)]
    (b/decode manic-miner-file in)))

(def room-names
  "Extrait les noms des pièces"
  (let [decoded (decode manic-miner-filename)
        room-names-list (map :room-name (:rooms decoded))]
    (map s/trim room-names-list)
    )
  )

(def central-cavern
  (let [decoded (decode manic-miner-filename)]
    (first (:rooms decoded))
    ))
