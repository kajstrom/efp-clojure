(ns efp-clojure.E02.e02-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E02.e02 :refer :all]))

(deftest test-string-length
  (testing "String length description"
           (is (= "Homer has 5 characters." (desc-string-length "Homer")))))