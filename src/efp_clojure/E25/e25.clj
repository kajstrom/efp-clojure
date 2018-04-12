(ns efp-clojure.E25.e25
  (:require [efp-clojure.utils.prompt :refer :all]))

(defn- contains-only-numbers
  [s]
  (some? (re-matches #"[0-9]*" s)))

(defn- contains-only-chars
  [s]
  (some? (re-matches #"[a-zA-Z]*" s)))

(defn- contains-numbers
  [s]
  (some? (re-matches #".*[0-9]{1,}.*" s)))

(defn- contains-chars
  [s]
  (some? (re-matches #".*[a-zA-Z]{1,}.*" s)))

(defn- contains-special-chars
  [s]
  (some? (re-matches #".*[^a-z^A-Z^0-9]{1,}.*" s)))

(defn is-very-weak-password
  [password]
  (and (< (count password) 8) (contains-only-numbers password)))

(defn is-weak-password
  [password]
  (and (< (count password) 8) (contains-only-chars password)))

(defn is-strong-password
  [password]
  (and (>= (count password) 8) (contains-numbers password) (contains-chars password)))

(defn is-very-strong-password
  [password]
  (and (>=  (count password) 8) (contains-numbers password) (contains-chars password) (contains-special-chars password)))


(defn password-strength
  [password]
  (cond
    (is-very-strong-password password) :very-strong
    (is-strong-password password) :strong
    (is-weak-password password) :weak
    (is-very-weak-password password) :very-weak
    :else :very-weak))

(def password-strength-descs {:very-strong "very strong password"
                               :strong "strong password"
                               :weak "weak password"
                               :very-weak "very weak password"
                               })

(def prompt-password (make-string-prompt "Enter a password:"))
(defn describe-password
  [password strength]
  (println "The password" password "is a" (strength password-strength-descs)))

(defn run []
  (let [password (prompt-password)]
    (describe-password password (password-strength password))))