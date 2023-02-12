(ns manic-miner.file
  (:require
   [org.clojars.smee.binary.core :as b]
    [clojure.java.io :as io]
    [clojure.string :as s]
    [manic-miner.tools :as tool]
   )
  )

(def manic-miner-filename
  "Mon fichier"
  (io/resource "manic_miner.tzx"))

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
