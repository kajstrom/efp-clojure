(ns efp-clojure.E31.heart-rate-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E31.heart-rate :refer :all]))

(deftest test-target-hr
  (testing "Target HR calculation"
           (is (= 130 (target-hr 187 60 55)))))