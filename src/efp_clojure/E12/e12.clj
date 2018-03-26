(ns efp-clojure.E12.e12
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.utils.number :refer :all]))

(def prompt-principal (make-int-prompt "Enter the principal: "))
(def prompt-rate (make-double-prompt "Enter the rate of interest: "))
(def prompt-years (make-int-prompt "Enter the number of years: "))

(defn output-result [years rate amount-after]
  (println (str "After " years " years at " rate "%, the investment will be worth $" amount-after ".")))

(defn calc-interest [principal rate years]
  (double-to-precision(* principal (+ 1 (/ (* rate years) 100))) 2 java.math.RoundingMode/CEILING))

(defn run []
  (let [principal (prompt-principal)
        rate (prompt-rate)
        years (prompt-years)]
    (output-result years rate (calc-interest principal rate years))))
