(ns efp-clojure.E24.e24-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E24.e24 :refer :all]
            [clojure.data :refer [diff]]))

(deftest test-string-to-charmap
  (testing "Converts string to hashmap with correct char count"
           (let [diffs (diff {\n 1 \o 1} (string-to-charmap "no"))]
             (is (nil? (get diffs 0)))
             (is (nil? (get diffs 1)))
             )))

(deftest test-are-anagrams
  (testing "Detecting words that are anagrams"
           (is (true? (are-anagrams "done" "node")))
           (is (true? (are-anagrams "NoTe" "TonE"))))
  (testing "Does not consider words that are not anagrams as anagrams"
           (is (false? (are-anagrams "sofa" "soda")))
           (is (false? (are-anagrams "truck" "puck")))
           (is (false? (are-anagrams "foork" "fork")))))