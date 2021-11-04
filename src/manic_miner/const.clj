(ns manic-miner.const)

(def MAGIC_OFFSET_CENTRAL_CAVERN (- 0x33B4 512)) ; offset de la première cave
(def MAGIC_OFFSET_LAST_CAVE (+ MAGIC_OFFSET_CENTRAL_CAVERN (* 1024 20))) ; offset de la dernière cave

(def ROOM_NAME_OFFSET_BEGIN 512)
(def ROOM_NAME_OFFSET_END (+ 512 32))
