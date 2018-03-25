(ns efp-clojure.E11.e11
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-amount (make-int-prompt "How many euros are you exchanging?"))
(def prompt-rate (make-double-prompt "What is the exchange rate?"))

(defn output-result [amount-from rate amount-to]
  (println (str amount-from " euros at exchange rate of " rate " is " amount-to " U.S. dollars.")))

(defn convert [amount rate]
  (let [percentage-rate (/ rate 100)]
    (.doubleValue (.setScale (* amount (bigdec percentage-rate)) 2 java.math.RoundingMode/CEILING))))

(defn run []
  (let [amount (prompt-amount)
        rate (prompt-rate)]
    (output-result amount rate (convert amount rate))))