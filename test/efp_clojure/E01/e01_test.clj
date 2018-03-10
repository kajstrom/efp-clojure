(ns efp-clojure.E01.e01-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E01.e01 :refer :all]))

(deftest tests-greeting-format
  (testing "Greeting formatting"
           (is (= "Hello, Kaj, nice to meet you!" (greet "Kaj")))))
