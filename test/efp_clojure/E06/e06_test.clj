(ns efp-clojure.E06.e06-test
  (:require [clojure.test :refer :all]
    [efp-clojure.E06.e06 :refer :all]))

(deftest test-calc-years-to-retirement
  (testing "Positive years to retirement"
           (is (= 20 (calc-years-to-retirement 40 60))))
  (testing "Negative years to retirement"
           (is (= -5 (calc-years-to-retirement 65 60)))))

(deftest test-calc-year-to-retire
  (testing "Positive years to retirement"
           (is (= 2020 (calc-year-to-retire 2 2018))))
  (testing "Negative years to retirement"
           (is (= 2016 (calc-year-to-retire -2 2018)))))