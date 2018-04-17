(ns efp-clojure.E31.heart-rate)

(defn hr-max
  [age]
  (- 220 age))

(defn target-hr
  [hr-max resting-hr intensity]
  (+ (Math/round (double (* (- hr-max resting-hr) (/ intensity 100)))) resting-hr))

(defn intensity-hr-table
  [hr-max resting-hr]
  (for [intensity (range 55 100 5)]
    {:intensity intensity :rate (target-hr hr-max resting-hr intensity)}))