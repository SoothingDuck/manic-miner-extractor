(ns manic-miner.room
  (:require [clojure.string :as s])
  (:require [manic-miner.tools :as tools])
  (:require [manic-miner.file :as file])
  (:require [manic-miner.const :as const]))

(defn title
  "Récupère le nom de la pièce"
  [room-array]
  (let [room-slice (tools/slice-array room-array const/ROOM_OFFSET_ROOM_NAME_BEGIN const/ROOM_OFFSET_ROOM_NAME_END)]
    (s/trim (apply str (map char room-slice)))
    ))

(defn data-list
  "Les données de chaque pièce séparées dans un vecteur"
  []
  (let [raw-data (file/raw-data)
        offset-rooms (range const/FILE_OFFSET_CENTRAL_CAVERN const/FILE_OFFSET_LAST_CAVE 1024)]
    (map #(tools/slice-array raw-data % (+ % 1024)) offset-rooms)))
