(ns efp-clojure.E15.e15
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-username (make-string-prompt "What is the username?"))
(def prompt-password (make-string-prompt "What is the password?"))

(def users (list {:username "Kaj" :password "passw0rd"} {:username "Tinja" :password "abracadabra"}))

(defn find-user [username]
  (first (filter #(= username (:username %)) users)))

(defn is-valid? [entered-pw stored-pw]
  (= entered-pw stored-pw))

(defn authenticate [username password]
  (if-let [user (find-user username)]
    (is-valid? password (get user :password))
    false))

(defn run[]
  (if (authenticate (prompt-username) (prompt-password))
    (println "Welcome!")
    (println "Invalid credentials")))