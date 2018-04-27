(ns efp-clojure.E38-file.e38-file
  (:require [clojure.string :as s]
            [efp-clojure.E38.filter-even :refer [filter-even]]))

(defn load-numbers
  []
  (map #(Integer/parseInt %) (s/split-lines (slurp (clojure.java.io/resource "numbers.dat")))))

(defn run
  []
  (println "The even numbers are" (s/join " " (filter-even (load-numbers)))))