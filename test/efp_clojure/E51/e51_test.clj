(ns efp-clojure.E51.e51-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E51.e51 :refer :all]))

(deftest test-parse-input
  (testing "new command"
           (let [parsed (parse-input "new This is my note")]
             (is (= :new (:command parsed)))
             (is (= "This is my note" (:params parsed)))))
  (testing "show command"
           (let [parsed (parse-input "show")]
             (is (= :show (:command parsed))))))