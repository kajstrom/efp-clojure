(ns efp-clojure.E03.e03-test
  (:require[clojure.test :refer :all]
      [efp-clojure.E03.e03 :refer :all]))

(deftest test-quote
  (testing "Quote formatting"
           (is (= "Kaj says, \"It is hard to remember the test definitions\"" (quote-originator "It is hard to remember the test definitions" "Kaj")))))