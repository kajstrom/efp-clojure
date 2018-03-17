(ns efp-clojure.E05.e05
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-first-number (make-int-prompt "What is the first number? "))

(def prompt-second-number (make-int-prompt "What is the second number? "))

(defn calculations
  [first second]
  (list
   (str first " + " second " = " (+ first second))
   (str first " - " second " = " (- first second))
   (str first " * " second " = " (* first second))
   (str first " / " second " = " (/ first second))))

(defn run
  []
  (doseq [res (calculations (prompt-first-number) (prompt-second-number))]
    (println res)))