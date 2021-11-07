(ns manic-miner.room-test
  (:require [clojure.test :refer :all]
            [manic-miner.room :as room]
            [manic-miner.file :as file]
            ))

(deftest central-cavern-name-test
  (testing "The room name of first cave is 'Central Cavern'"
    (let [first-room (first (file/room-data-list))]
    (is (= "Central Cavern" (room/title first-room))))))

(deftest final-barrier-name-test
  (testing "The room name of last cave is 'The Final Barrier'"
    (let [last-room (last (file/room-data-list))]
    (is (= "The Final Barrier" (room/title last-room))))))
