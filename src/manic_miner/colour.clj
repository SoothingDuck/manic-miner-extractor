(ns manic-miner.colour
  (:require [manic-miner.colour :as colour]))


(def set
  "Colour codes used for colour attributes"
  {
   2r000 :black
   2r001 :blue
   2r010 :red
   2r011 :magenta
   2r100 :green
   2r101 :cyan
   2r110 :yellow
   2r111 :white
   }
  )

(defn attributes
  "Get colour attributes from screen layout"
  [byte-value]
  {
   :flash (bit-shift-right (bit-and byte-value 2r10000000) 7)
   :brightness (bit-shift-right (bit-and byte-value 2r01000000) 6)
   :paper-colour (get set (bit-shift-right (bit-and byte-value 2r00111000) 3))
   :ink-colour (get set (bit-shift-right (bit-and byte-value 2r00000111) 0))
   }
  )
