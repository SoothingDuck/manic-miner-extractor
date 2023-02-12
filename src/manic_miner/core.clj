(ns manic-miner.core
  (:require
    [manic-miner.file :as file]
    [manic-miner.colour :as colour]
    )
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )

(let [layout (:screen-layout file/central-cavern)
      node-list (map (comp :paper-colour colour/attributes) layout)
      ]
  node-list
  )

(prn file/room-names)
