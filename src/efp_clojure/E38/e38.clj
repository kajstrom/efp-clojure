(ns efp-clojure.E38.e38
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt (make-string-prompt "Enter a list of numbers, separated by spaces:"))

(defn number-string->number-list
  [values-string]
    (map #(Integer/parseInt %) (clojure.string/split values-string #" ")))

(def filter-even (partial filter #(= (mod % 2) 0)))

(defn run
  []
  (println "The even numbers are" (clojure.string/join  " "(filter-even (number-string->number-list (prompt))))))