(ns manic-miner.core-test
  (:require [clojure.test :refer :all]
            [manic-miner.core :refer :all]))

;; Room names
(deftest good-first-room-name
  (testing "First room is Central Cavern"
    (is (= (first manic-miner-room-names) "Central Cavern"))))

(deftest good-last-room-name
  (testing "Last room is Final Barrier"
    (is (= (last manic-miner-room-names) "The Final Barrier"))))

;; Colour attributes
(deftest colour-attribute-22
  (testing "The good colour attribues for 22"
    (is (= (colour-attributes 22) 
           {
            :flash 0
            :brightness 0
            :paper-colour :red 
            :ink-colour :yellow
            }
           ))))

