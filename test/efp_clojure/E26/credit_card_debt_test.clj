(ns efp-clojure.E26.credit-card-debt-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E26.credit-card-debt :refer :all]))

(deftest test-months-until-paid-off
  (testing "Calculates months until paid off"
           (is (= 70 (months-until-paid-off 5000 12 100)))))