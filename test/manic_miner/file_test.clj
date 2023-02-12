(ns manic-miner.file-test
  (:require
   [manic-miner.file :as file]
   [clojure.test :refer :all]
   ))


;; Room names
(deftest good-first-room-name
  (testing "First room is Central Cavern"
    (is (= (first file/room-names) "Central Cavern"))))

(deftest good-last-room-name
  (testing "Last room is Final Barrier"
    (is (= (last file/room-names) "The Final Barrier"))))
