(ns efp-clojure.E25.e25-test
  (:require [clojure.test :refer :all]
            [efp-clojure.E25.e25 :refer :all]))

(deftest test-is-very-weak-password
  (testing "Detects very weak passwords"
           (is (true? (is-very-weak-password "123456"))))
  (testing "Does not give false positives for passwords that are not very weak"
           (is (false? (is-very-weak-password "123456789")))
           (is (false? (is-very-weak-password "abcde")))))

(deftest test-is-weak-password
  (testing "Detects weak passwords"
           (is (true? (is-weak-password "abcdef"))))
  (testing "Does not give false positives for passwords that are not weak"
           (is (false? (is-weak-password "123abc")))
           (is (false? (is-weak-password "abcdefghijklm")))))

(deftest test-is-strong-password
  (testing "Detects strong passwords"
           (is (true? (is-strong-password "abc1defg")))
           (is (true? (is-strong-password "1abcdefgh"))))
  (testing "Does not give false positives for passwords that are not strong"
           (is (false? (is-strong-password "aaaa")))
           (is (false? (is-strong-password "12345678")))
           (is (false? (is-strong-password "abc123")))))

(deftest test-is-very-strong-password
  (testing "Detects very strong passwords"
           (is (true? (is-very-strong-password "abc123...34"))))
  (testing "Does not give false positives for passwords that are not very strong"
           (is (false? (is-very-strong-password "abceewrw21312312312")))
           (is (false? (is-very-strong-password "abc$$$")))
           (is (false? (is-very-strong-password "$$$$$€€€€€€@@££@£@££")))
           (is (false? (is-very-strong-password "2313134$$$€££$£@234234242")))))


(deftest test-password-strength
  (testing "Detect very strong passwords"
           (is (= :very-strong (password-strength "abc123...34"))))
  (testing "Detects strong passwords"
           (is (= :strong (password-strength "abc1defg"))))
  (testing "Detects weak passwords"
           (is (= :weak (password-strength "abcdef"))))
  (testing "Detects very weak passwords"
           (is (= :very-weak (password-strength "123456")))))