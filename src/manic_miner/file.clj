(ns manic-miner.file
  (:require
   [org.clojars.smee.binary.core :as b]
    [clojure.java.io :as io]
    [manic-miner.tools :as tool]
    [manic-miner.room :as room]
    [manic-miner.constant :as constant]
   )
  )

(def tzx-filename
  "Mon fichier"
  (io/resource constant/FILE_TZX_NAME))

(def manic-miner-file
  "Description globale du fichier manic miner"
  (b/ordered-map
    :header-junk (tool/byte-list constant/FILE_ROOM_OFFSET)
    :rooms (b/repeated room/manic-miner-room :length constant/FILE_TOTAL_ROOM_NUMBER)
    )
  )

(defn decode
  "Fonction pour décoder un fichier manic miner"
  [filename]
  (let [in (io/input-stream filename)]
    (b/decode manic-miner-file in)))

(def room-list
  "Extrait les pièces"
  (let [decoded (decode tzx-filename)
        room-list (:rooms decoded)]
    room-list))

