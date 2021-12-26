(ns manic-miner.color)

(defn byte-to-color
  "Convertit un byte en couleur"
  [color-byte]
  (let [boolean-conv {true 1 false 0}
        flash (get boolean-conv (bit-test color-byte 7))
        brightness (get boolean-conv (bit-test color-byte 6))
        color-list {
                    0 :black
                    1 :blue
                    2 :red
                    3 :magenta
                    4 :green
                    5 :cyan
                    6 :yellow
                    7 :white
                    }
        paper-byte (bit-shift-right (bit-and 2r00111000 color-byte) 3)
        ink-byte (bit-and 2r00000111 color-byte)
        paper-color (get color-list paper-byte)
        ink-color (get color-list ink-byte)
        ]
    ;; {:flash (get boolean-conv (bit-test 0 color-byte))}
    {
     :flash flash
     :brightness brightness
     :paper-color paper-color
     :ink-color ink-color
     }
    )
  )
