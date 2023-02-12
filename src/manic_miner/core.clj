(ns manic-miner.core
  (:require
    [manic-miner.room :as room]
    [manic-miner.colour :as colour]
    )
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )

(let [layout (:screen-layout room/central-cavern)
      node-list (map (comp :paper-colour colour/attributes) layout)
      ]
  node-list
  )


