(ns efp-clojure.E10.e10-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E10.e10 :refer :all]))

(deftest test-checkout
  (testing "Checking out items"
           (let [checkout (checkout-items (list {:price 25 :quantity 2} {:price 10 :quantity 1}))]
             (is (= 60 (:subtotal checkout)))
             (is (= 3.3 (:tax checkout)))
             (is (= 63.3 (:total checkout))))))

(deftest test-item-checkout
  (testing "Checking out a single item"
           (let [checkout (item-checkout {:subtotal 0 :tax 0 :total 0} {:price 25 :quantity 2})]
             (is (= 50 (:subtotal checkout)))
             (is (= 2.75 (:tax checkout)))
             (is (= 52.75 (:total checkout))))))