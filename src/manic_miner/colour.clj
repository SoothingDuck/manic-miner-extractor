(ns manic-miner.colour
  (:require
   [manic-miner.colour :as colour]
   [manic-miner.constant :as constant]
   ))

(def zx-spectrum-color-codes
  "Les correspondances zx-spectrum"
{
 :black [0 0 0]
 :blue [0 0 255]
 :red [255 0 0]
 :magenta [255 0 255]
 :green [0 255 0]
 :cyan [0 255 255]
 :yellow [255 255 0]
 :white [255 255 255]
 }
  )

(def codes
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
   :flash (bit-shift-right (bit-and byte-value constant/MASK_BLOCK_FLASH) 7)
   :brightness (bit-shift-right (bit-and byte-value constant/MASK_BLOCK_BRIGHTNESS) 6)
   :paper-colour (get codes (bit-shift-right (bit-and byte-value constant/MASK_BLOCK_PAPER_COLOUR) 3))
   :ink-colour (get codes (bit-shift-right (bit-and byte-value constant/MASK_BLOCK_INK_COLOUR) 0))
   }
  )
