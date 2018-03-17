(ns efp-clojure.E05.e05-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E05.e05 :refer :all]))

(deftest test-simple-math
  (testing "Simple Math"
           (let [res (calculations 10 5)]
             (is (= "10 + 5 = 15" (nth res 0)))
             (is (= "10 - 5 = 5" (nth res 1)))
             (is (= "10 * 5 = 50" (nth res 2)))
             (is (= "10 / 5 = 2" (nth res 3)))
             )))