(ns manic-miner.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as s])
  (:require [manic-miner.const :as const])
  (:require [manic-miner.room :as room])
  (:require [manic-miner.file :as file])
  (:require [manic-miner.tools :as tools]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (map room/title (file/room-data-list))))
