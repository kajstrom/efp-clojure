(ns efp-clojure.E08.e08-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E08.e08 :refer :all]))

(deftest test-slices-per-person
  (testing "Even slices per person"
           (is (= 2 (:per-person (slices-per-person 2 2 2))))
           (is (= 0 (:leftover (slices-per-person 2 2 2)))))
  (testing "Uneven slices per person"
           (is (= 1 (:per-person (slices-per-person 2 2 3))))
           (is (= 1 (:leftover (slices-per-person 2 2 3))))))