(ns efp-clojure.E17.e17-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E17.e17 :refer :all]))

(deftest test-calculate-bac
  (testing "Calculation for Women"
           (is (= 0.16 (calc-bac {:weight 120 :sex "W"} {:amount-oz 3 :hours-since-last 2}))))
  (testing "Calculation for Men"
           (is (= 0.15 (calc-bac {:weight 120 :sex "M"} {:amount-oz 3 :hours-since-last 2})))))