(ns manic-miner.core
  (:require
    [clojure.pprint    :refer [pprint]]
    [manic-miner.file  :as    file]
    [manic-miner.room  :as    room]
    
    )
  (:gen-class))

;; https://www.icemark.com/dataformats/manic/mmformat.htm


;; https://stackoverflow.com/questions/6973290/generate-and-save-a-png-image-in-clojure
;; https://github.com/Serabe/rinzelight

(defn -main
  "But premier, récupérer le nom de toutes les caves"
  [& _]
  (let [numbered-room-list (map vector (range) file/room-list)
        
        central-cavern (second (first numbered-room-list))
        room-number    (+ (first (first numbered-room-list)) 1)
        name           (room/pretty-name central-cavern)
        elements       (:elements central-cavern)]
    ;; Room name
    (pprint name)
    ;; Room number
    (pprint room-number)
    ;; Background block
    (pprint (map vector (keys elements) (vals elements)))
    )
  )

