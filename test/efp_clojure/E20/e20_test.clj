(ns efp-clojure.E20.e20-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E20.e20 :refer :all]))

(deftest test-calculate-total
  (testing "Calculation for a state with no sales tax"
           (let [total (calculate-total "new York" nil 10)]
             (is (= 10.0 (:total total)))
             (is (nil? (:tax total)))))
  (testing "Calculation for a state with sales tax but no county tax"
           (let [total (calculate-total "illinois" nil 10)]
             (is (= 10.8 (:total total)))
             (is (= 0.8 (:tax total)))))
  (testing "Calculation for a state with sales tax and county tax"
           (let [total (calculate-total "wisconsin" "eau claire" 10)]
             (is (= 10.55 (:total total)))
             (is (= 0.55 (:tax total))))))

(deftest test-find-state
  (testing "Finds a state with state tax"
           (is (= "wisconsin" (:name (find-state "wisconsin")))))
  (testing "Does not find a state with no state tax"
           (is (nil? (find-state "north carolina")))))

(deftest test-find-county-tax
  (testing "Finds county tax for a county with tax"
           (is (= 0.004 (find-county-tax {:name "Some State" :tax 0.08 :counties '({:name "County 1" :tax 0.004})} "County 1")))))

(deftest test-calculate-state-tax
  (testing "Calculates tax for state with only state tax"
           (is (= 0.8 (calculate-state-tax {:name "Some State" :tax 0.08} nil 10))))
  (testing "Calculates tax for a state with state and county tax"
           (is (= 0.84 (calculate-state-tax {:name "Some State" :tax 0.08 :counties (list {:name "County 1" :tax 0.004})} "County 1" 10))))
  (testing "Calculates only state tax when county has no tax but other counties in state do have"
           (is (= 0.8 (calculate-state-tax {:name "Some State" :tax 0.08 :counties (list {:name "County 1" :tax 0.004})} "County 2" 10)))))