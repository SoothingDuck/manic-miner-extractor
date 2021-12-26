(ns manic-miner.const)

; Offset in file
(def FILE_OFFSET_CENTRAL_CAVERN (- 0x33B4 512)) ; offset de la première cave
(def FILE_OFFSET_LAST_CAVE (+ FILE_OFFSET_CENTRAL_CAVERN (* 1024 20))) ; offset de la dernière cave

; Offset in room
(def ROOM_OFFSET_ROOM_NAME_BEGIN 512)
(def ROOM_OFFSET_ROOM_NAME_END (+ ROOM_OFFSET_ROOM_NAME_BEGIN 32))

; Offset layout
(def ROOM_OFFSET_ROOM_LAYOUT_BEGIN 0)
(def ROOM_OFFSET_ROOM_LAYOUT_END 512)
