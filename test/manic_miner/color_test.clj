(ns manic-miner.color-test
  (:require [clojure.test :refer :all]
            [manic-miner.color :refer :all]))

(deftest test-flash
  (testing "Let there be flash"
    (let [
          flash (manic-miner.color/byte-to-color 2r10111000)
          not-flash (manic-miner.color/byte-to-color 2r00111000)
          ]
      (is (= (:flash flash) 1))
      (is (= (:flash not-flash) 0))
      )
    ))

(deftest test-brightness
  (testing "Let there be brightness"
    (let [
          bright (manic-miner.color/byte-to-color 2r01111000)
          not-bright (manic-miner.color/byte-to-color 2r00111000)
          ]
      (is (= (:brightness bright) 1))
      (is (= (:brightness not-bright) 0))
      )
    ))

(deftest color-paper
  (let [
        black (manic-miner.color/byte-to-color 2r11000111)
        blue (manic-miner.color/byte-to-color 2r11001111)
        red (manic-miner.color/byte-to-color 2r11010111)
        magenta (manic-miner.color/byte-to-color 2r11011111)
        green (manic-miner.color/byte-to-color 2r00100111)
        cyan (manic-miner.color/byte-to-color 2r11101111)
        yellow (manic-miner.color/byte-to-color 2r11110111)
        white (manic-miner.color/byte-to-color 2r00111000)
        ]
    (is (= (:paper-color black) :black))
    (is (= (:paper-color blue) :blue))
    (is (= (:paper-color red) :red))
    (is (= (:paper-color magenta) :magenta))
    (is (= (:paper-color green) :green))
    (is (= (:paper-color cyan) :cyan))
    (is (= (:paper-color yellow) :yellow))
    (is (= (:paper-color white) :white))
    )
  )

(deftest ink-paper
  (let [
        black (manic-miner.color/byte-to-color 2r11111000)
        blue (manic-miner.color/byte-to-color 2r11111001)
        red (manic-miner.color/byte-to-color 2r11111010)
        magenta (manic-miner.color/byte-to-color 2r11111011)
        green (manic-miner.color/byte-to-color 2r00111100)
        cyan (manic-miner.color/byte-to-color 2r11111101)
        yellow (manic-miner.color/byte-to-color 2r11111110)
        white (manic-miner.color/byte-to-color 2r00000111)
        ]
    (is (= (:ink-color black) :black))
    (is (= (:ink-color blue) :blue))
    (is (= (:ink-color red) :red))
    (is (= (:ink-color magenta) :magenta))
    (is (= (:ink-color green) :green))
    (is (= (:ink-color cyan) :cyan))
    (is (= (:ink-color yellow) :yellow))
    (is (= (:ink-color white) :white))
    )
  )
