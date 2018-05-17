(ns efp-clojure.E46.e46
  (:require
    [clojure.string :as s]
    [clojure.java.io :as io]))

(defn split-to-words
  [text]
  (s/split (s/join " "(flatten(s/split-lines text))) #" "))

(defn count-words
  [words]
  (sort-by second > (map #(vector (first %) (count (second %))) (group-by identity words))))

(defn display-word-count
  [word-counts]
  (doseq [word word-counts]
    (println (str (first word) ":") (s/join(repeat (second word) "*")))))

(defn run
  []
  (display-word-count (count-words (split-to-words (slurp (io/resource "E46_words.dat"))))))