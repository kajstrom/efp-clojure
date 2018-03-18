(ns efp-clojure.E07.e07-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E07.e07 :refer :all]))

(deftest test-area-from-dimensions
  (testing "Calculates area correctly"
           (is (= 300 (area-from-dimensions 15 20)))))

(deftest test-square-feet-to-square-meters
  (testing "Converts square feet to meters correctly"
           (is (= 27.870912 (square-feet-to-square-meters 300)))))