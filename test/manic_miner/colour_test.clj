(ns manic-miner.colour-test
  (:require
   [clojure.test :refer :all]
   [manic-miner.colour :as colour]
   ))


;; Colour attributes
(deftest colour-attribute-22
  (testing "The good colour attribues for 22"
    (is (= (colour/attributes 22)
           {
            :flash 0
            :brightness 0
            :paper-colour :red
            :ink-colour :yellow
            }
           ))))
