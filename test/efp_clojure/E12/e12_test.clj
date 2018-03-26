(ns efp-clojure.E12.e12-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E12.e12 :refer :all]))

(deftest test-calc-interest
  (testing "Calculates interest correctly"
           (is (= 1758.00 (calc-interest 1500 4.3 4)))
           (is (= 2832.00 (calc-interest 2000 5.2 8)))
           (is (= 2833.60 (calc-interest 2000 5.21 8)))))