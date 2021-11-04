(ns manic-miner.room-test
  (:require [clojure.test :refer :all]
            [manic-miner.room :as room]
            ))

(deftest central-cavern-name-test
  (testing "The room name of first cave is 'Central Cavern'"
    (let [first-room (first (room/data-list))]
    (is (= "Central Cavern" (room/name first-room))))))

(deftest final-barrier-name-test
  (testing "The room name of last cave is 'The Final Barrier'"
    (let [last-room (last (room/data-list))]
    (is (= "The Final Barrier" (room/name last-room))))))
