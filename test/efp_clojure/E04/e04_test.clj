(ns efp-clojure.E04.e04-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E04.e04 :refer :all]))

(deftest test-madlib
  (testing "Mad lib sentence generating"
           (is (= "Do you eat your green oatmeal slowly? That's hilarious!" (mad-lib "oatmeal" "eat" "green" "slowly")))))