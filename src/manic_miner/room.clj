(ns manic-miner.room
  (:require [clojure.string :as s])
  (:require [manic-miner.tools :as tools])
  (:require [manic-miner.file :as file])
  (:require [manic-miner.const :as const]))

(defn name
  "Récupère le nom de la pièce"
  [room-array]
  (let [room-slice (tools/slice-array room-array const/ROOM_NAME_OFFSET_BEGIN const/ROOM_NAME_OFFSET_END)]
    (s/trim (apply str (map char room-slice)))
    ))

(defn manic-miner-rooms-data
  "Les données de chaque pièce séparées dans un vecteur"
  []
  (let [raw-data (file/manic-miner-raw-data)
        offset-rooms (range const/MAGIC_OFFSET_CENTRAL_CAVERN const/MAGIC_OFFSET_LAST_CAVE 1024)]
    (map #(tools/slice-array raw-data % (+ % 1024)) offset-rooms)))
