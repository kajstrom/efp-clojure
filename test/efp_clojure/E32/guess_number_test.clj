(ns efp-clojure.E32.guess-number-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E32.guess-number :refer :all]))

(deftest test-guess
  (testing "Low guess"
           (reset! answer 30)
           (is (= :low (guess 25))))
  (testing "High guess"
           (reset! answer 30)
           (is (= :high (guess 35))))
  (testing "Correct guess"
           (reset! answer 30)
           (is (= :correct (guess 30)))))