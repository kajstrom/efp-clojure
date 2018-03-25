(ns efp-clojure.E11.e11-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E11.e11 :refer :all]))

(deftest test-convert
  (testing "Converts currency"
           (is (= 111.39 (convert 81 137.51)))))