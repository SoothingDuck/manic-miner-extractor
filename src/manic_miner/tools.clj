(ns manic-miner.tools)

(defn to-hex-string-byte
  "Conversion d'un byte en sa valeur hexadecimale"
  [b]
  (let [int_value (int b)]
    (Integer/toHexString int_value)))

(defn to-hex-string-array
  "Conversion d'un tableau de byte en un tableau de chaines hexadécimales"
  [a]
  (map to-hex-string-byte (seq a))
  )

(defn slice-array
  "Returns a manageable slice of an array"
  [arr begin end]
  (vec (subvec arr begin end)))
