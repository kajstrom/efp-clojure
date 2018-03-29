(ns efp-clojure.E13.e13-test
  (:require [clojure.test :refer :all]
    [efp-clojure.E13.e13 :refer :all]))

(deftest test-compount-interest
  (testing "Compound interest calculation"
           (is (= 1938.84 (compound-interest 1500 4.3 6 4)))))