(ns efp-clojure.E15.e15-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E15.e15 :refer :all]))

(deftest test-authenticate
  (testing "Authentication with existing credentials"
           (is (true? (authenticate "Kaj" "passw0rd")))
           (is (true? (authenticate "Tinja" "abracadabra"))))
  (testing "Authentication with existing username but invalid password"
           (is (false? (authenticate "Kaj" "1234"))))
  (testing "Authencation with non-existing username"
           (is (false? (authenticate "mradmin" "r00t")))))

(deftest test-find-user
  (testing "Finding existing user"
           (is (= "Kaj" (:username (find-user "Kaj"))))))