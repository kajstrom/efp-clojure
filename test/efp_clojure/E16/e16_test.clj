(ns efp-clojure.E16.e16-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E16.e16 :refer :all]))

(deftest testing-countries-allowed-to-drive-at-age
  (testing "Filtering countries"
           (is (= 1 (count (countries-allowed-to-drive-at-age 16))))
           (is (empty? (countries-allowed-to-drive-at-age 12)))))