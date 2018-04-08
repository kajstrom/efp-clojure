(ns efp-clojure.E22.e22-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E22.e22 :refer :all]))

(deftest test-largest-number
  (testing "Finds the largest number"
           (is (= 2 (largest-number 2 1 1)))
           (is (= 2 (largest-number 1 2 1)))
           (is (= 2 (largest-number 1 1 2))))
  (testing "Returns nil if all numbers are equal"
           (is (nil? (largest-number 1 1 1)))
           (is (nil? (largest-number 12 12 12)))))