(ns manic-miner.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [byte-streams :as bytes])
  (:require [manic-miner.dump :as dump])
  (:require [manic-miner.const :as const])
  (:require [manic-miner.tools :as tools])
  (:require [clojure.string :as string])
  )





(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  ; map char (take 5 (file->bytes dump/manic-miner-filename)))
  (let [raw-dump (tools/file->bytes dump/manic-miner-filename)
  					 [x y] (split-at (+ 512 const/FILE_OFFSET_CENTRAL_CAVERN) raw-dump)]
				(println (string/trim (reduce str (map char (take 32 y)))))
  )

 )
