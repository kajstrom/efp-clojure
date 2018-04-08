(ns efp-clojure.E22.e22
  (:require [efp-clojure.utils.prompt :refer :all]))

;The point of the exercise is not to use any built-in collection functions to find the largest number.

(defn largest-number
  "Returns the largest provided number or nil if the numbers are all equal"
  [n1 n2 n3]
  (if (= 0 (mod (+ n1 n2 n3) 3))
    nil
    (if (> n1 n2)
      (if (> n1 n3)
        n1
        n3)
      (if (> n2 n3)
        n2
        n3))))

(def prompt-first (make-int-prompt "Enter the first number"))
(def prompt-second (make-int-prompt "Enter the second number"))
(def prompt-third (make-int-prompt "Enter the third number"))

(defn run []
  (if-let [largest (largest-number (prompt-first) (prompt-second) (prompt-third))]
    (println (str "The largest number is " largest "."))))