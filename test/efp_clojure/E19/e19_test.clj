(ns efp-clojure.E19.e19-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E19.e19 :refer :all]))

(deftest test-bmi
  (testing "BMI Calculation"
           (is (= 22.0 (bmi 80 200))))
  (testing "BMI Description"
           (is (= "Your BMI is 15.0.\nYou are underweight. You should see a doctor." (bmi-desc 15.0)))
           (is (= "Your BMI is 23.0.\nYou are within the ideal weight range." (bmi-desc 23.0)))
           (is (= "Your BMI is 33.0.\nYou are overweight. You should see a doctor." (bmi-desc 33.0)))))