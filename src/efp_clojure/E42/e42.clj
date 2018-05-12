(ns efp-clojure.E42.e42
  (:require
    [clojure.string :as s]))

(defn parse-salaries
  [lines]
  (let [parsed-lines (map  #(s/split % #",") (s/split-lines lines))]
    (map #(hash-map
       "Last" (get % 0)
       "First" (get % 1)
       "Salary" (get % 2)
           ) parsed-lines)))

(defn run
  []
  (let [salaries (parse-salaries (slurp (clojure.java.io/resource "E42_salaries.dat")))]
    (clojure.pprint/print-table ["Last" "First" "Salary"] salaries)))