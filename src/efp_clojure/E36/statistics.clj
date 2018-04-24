(ns efp-clojure.E36.statistics
  (:require [clojure.math.numeric-tower :refer [expt sqrt]]))

(defn average [numbers] (/ (apply + numbers) (count numbers)))

(defn std-deviation [numbers]
  (let [mean (average numbers)]
    (sqrt (average (map #(expt (- % mean) 2) numbers)))))

(defn statistics
  [numbers]
  {:average (average numbers)
   :minimum (apply min numbers)
   :maximum (apply max numbers)
   :std-deviation (std-deviation numbers)})