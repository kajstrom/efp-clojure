(ns efp-clojure.E18.e18-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E18.e18 :refer :all]))

(deftest test-temperature-conversions
  (testing "Convert Celsius to Fahrenheit"
           (is (= 68 (celsius-to-fahrenheit 20))))
  (testing "Convert Fahrenheit to Celsius"
           (is (= 20 (fahrenheit-to-celsius 68)))))