(ns efp-clojure.E13.e13
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.utils.number :refer :all]
            [clojure.math.numeric-tower :refer :all]))

(def prompt-principal (make-int-prompt "What is the principal amount?"))
(def prompt-rate (make-double-prompt "What is the rate?"))
(def prompt-years (make-int-prompt "What is the number of years?"))
(def prompt-compounds (make-int-prompt "What is the number of times the interest is compounded per year?"))

(defn output-result
  [principal rate years compounds amount]
  (println (str "$" principal " invested at " rate "% for " years " years compounded " compounds " times per year is $" amount)))

(defn compound-interest
  [principal rate years compounds]
  (let [percentage-rate (/ rate 100)]
    (double-to-precision
     (* principal (expt (+ 1 (/ percentage-rate compounds)) (* years compounds)))
     2 java.math.RoundingMode/HALF_UP)))

(defn run
  []
  (let [principal (prompt-principal)
        rate (prompt-rate)
        years (prompt-years)
        compounds (prompt-compounds)]
    (output-result
     principal
     rate
     years
     compounds
     (compound-interest principal rate years compounds))))