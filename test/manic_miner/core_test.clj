(ns manic-miner.core-test
  (:require [clojure.test :refer :all]
            [manic-miner.core :refer :all]))

(deftest good-first-room-name
  (testing "First room is Central Cavern"
    (is (= (first manic-miner-room-names) "Central Cavern"))))

(deftest good-last-room-name
  (testing "Last room is Final Barrier"
    (is (= (last manic-miner-room-names) "The Final Barrier"))))
