(ns efp-clojure.E14.e14
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-amount (make-int-prompt "What is the order amount?"))
(def prompt-state (make-string-prompt "What is the state?"))

(defn calculate-tax
  [amount state]
  (let [order  {:subtotal amount :tax 0.0 :tax-applicable false :total amount}
        tax (* amount 0.055)]
    (if (= "WI" (clojure.string/upper-case state))
      (assoc order :tax tax :total (+ amount tax) :tax-applicable true)
      order)))

(defn output-result
  [order]
  (println (str "The subtotal is $" (:subtotal order)))
  (if (:tax-applicable order)
    (println (str "The tax is $" (:tax order))))
  (println (str "The total is $" (:total order))))

(defn run []
  (output-result (calculate-tax (prompt-amount) (prompt-state))))