(ns efp-clojure.E09.e09-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E09.e09 :refer :all]))

(deftest test-calc-paint-amount
  (testing "Paint amount calculation"
           (is (= 1 (calc-paint-amount {:width 5 :length 50})))
           (is (= 2 (calc-paint-amount {:width 10 :length 50})))))