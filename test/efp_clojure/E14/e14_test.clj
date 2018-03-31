(ns efp-clojure.E14.e14-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E14.e14 :refer :all]))

(deftest test-calculate-tax
  (testing "Tax calculation in Wisconsin"
           (let [order (calculate-tax 10 "WI")]
             (is (= 10.55 (:total order)))
             (is (= 0.55 (:tax order)))
             (is (true? (:tax-applicable order)))))
  (testing "Tax calculation in other states"
           (let [order (calculate-tax 10 "NY")]
             (is (= 10 (:total order)))
             (is (= 0.0 (:tax order)))
             (is (false? (:tax-applicable order))))))