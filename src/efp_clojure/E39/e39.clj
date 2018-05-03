(ns efp-clojure.E39.e39
  (:require [efp-clojure.E39.employee-record :refer :all]))

(defn run
  []
  (clojure.pprint/print-table ["Name" "Position" "Separation Date"] (format-for-printing employees)))