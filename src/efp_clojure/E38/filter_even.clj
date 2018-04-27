(ns efp-clojure.E38.filter-even)

(def filter-even (partial filter #(= (mod % 2) 0)))