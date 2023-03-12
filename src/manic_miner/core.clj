(ns manic-miner.core
  (:require
   [manic-miner.file :as file]
   [manic-miner.block :as block]
   [manic-miner.room :as room])
  (:gen-class)
  )

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]

  )

(def first-nasty (first (room/room-nasties file/central-cavern)))
(def second-nasty (second (room/room-nasties file/central-cavern)))

;; (prn (block/rgb-colour first-nasty))

;;; Afficher le mapping
;; (room/save-nasties file/central-cavern "DATA/central_cavern_")

;; (doseq [[i room] (map-indexed vector file/room-list)]
;;   (let [room-name (room/formatted-room-name room)
;;         data-prefix (str "output/" (format "%02d" (+ i 1)) "_" room-name "_")
;;         ]
;;     ;; nasties
;;     (room/save-nasties room data-prefix)
;;     )
;;   )
(prn (first (:guardian-graphics file/central-cavern)))
