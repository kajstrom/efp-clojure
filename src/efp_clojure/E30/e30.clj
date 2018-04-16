(ns efp-clojure.E30.e30
  (:require [efp-clojure.E30.multiplication-table :refer [multiplication-of]]))

(defn run
  []
  (let [table (multiplication-of 12)]
      (doseq [number-table table]
        (doseq [row number-table]
          (println (:x row) "X" (:y row) "=" (:res row))))))