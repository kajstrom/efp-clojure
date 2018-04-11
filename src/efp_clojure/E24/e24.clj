(ns efp-clojure.E24.e24
  (:require [efp-clojure.utils.prompt :refer :all]
            [clojure.data :refer [diff]]
            [clojure.string :as s]))

(defn string-to-charmap
  [s]
  (apply hash-map (flatten (map (fn [[k v]] (list k (count v)))(group-by identity (seq s))))))

(defn are-anagrams
  [s1 s2]
  (let [diffs (diff (string-to-charmap (s/lower-case s1)) (string-to-charmap (s/lower-case s2)))]
    (and (nil? (first diffs)) (nil? (second diffs)))))

(def instructions
  (make-output "Enter two strings and I'll tell you if they are anagrams:"))
(def prompt-first (make-string-prompt "Enter the first string:"))
(def prompt-second (make-string-prompt "Enter the second string:"))

(defn output-are-anagrams
  [s1 s2]
  (println (str "\"" s1 "\" and \"" s2 "\" are anagrams.")))

(defn outpur-are-not-anagrams
  [s1 s2]
  (println (str "\"" s1 "\" and \"" s2 "\" are not anagrams.")))

(defn run
  []
  (instructions)
  (let [s1 (prompt-first)
        s2 (prompt-second)]
    (if (are-anagrams s1 s2)
      (output-are-anagrams s1 s2)
      (outpur-are-not-anagrams s1 s2))))