(ns manic-miner.tools
(:require
   [org.clojars.smee.binary.core :as b]
   )
)

(defn byte-list [len]
  (b/repeated :byte :length len))
