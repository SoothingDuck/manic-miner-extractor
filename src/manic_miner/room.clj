(ns manic-miner.room
  (:require [clojure.string :as s])
  (:require [manic-miner.tools :as tools])
  (:require [manic-miner.file :as file])
  (:require [manic-miner.const :as const]))

(def rooms
  [
   {:name "Central Cavern"}
   {:name "Moda"}
   ]
  )

(defn title
  "Récupère le nom de la pièce"
  [room-array]
  (let [room-slice (tools/slice-array room-array const/ROOM_OFFSET_ROOM_NAME_BEGIN const/ROOM_OFFSET_ROOM_NAME_END)]
    (s/trim (apply str (map char room-slice)))
    ))

(defn layout
  "Récupère la disposition de la pièce"
  [room-array]
  (let [layout-vec (tools/slice-array room-array const/ROOM_OFFSET_ROOM_LAYOUT_BEGIN const/ROOM_OFFSET_ROOM_LAYOUT_END)]
    (partition 32 layout-vec)
    )
  )
