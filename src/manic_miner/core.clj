(ns manic-miner.core
  (:gen-class)
  (:require [manic-miner.dump :as dump])
  (:require [manic-miner.const :as const])
  (:require [manic-miner.tools :as tools])
  (:require [clojure.string :as string])
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& _]

  ; map char (take 5 (file->bytes dump/manic-miner-filename)))
  (let [raw-dump (tools/file->bytes dump/manic-miner-filename)
  					 [_ y] (split-at (+ 512 const/FILE_OFFSET_CENTRAL_CAVERN) raw-dump)]
				(println (string/trim (reduce str (map char (take 32 y)))))
  )

 )
