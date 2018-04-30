(ns efp-clojure.E39.e39
  (:require [efp-clojure.E39.employee-record :refer :all]))

(defn format-for-printing
  [employees]
  (map #(hash-map "Name" (str (:first-name %) " " (:last-name %))
         "Position" (:position %)
         "Separation Date" (:sep-date %)) (sort-by :last-name employees)))

(defn run
  []
  (clojure.pprint/print-table ["Name" "Position" "Separation Date"] (format-for-printing employees)))