(ns efp-clojure.E20.e20
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.utils.number :refer :all]
            [clojure.string :as s]))

(def states '({:name "wisconsin" :tax 0.05 :counties (list {:name "Eau Claire" :tax 0.005} {:name "dunn" :tax 0.004})}
             {:name "illinois" :tax 0.08}))

(defn find-state [state]
  (some #(if (= state (:name %)) %) states))

(defn state-county-tax? [state-name]
  (if-let [state (find-state state-name)]
    (nil? (:counties state))
    false))

(defn find-county-tax [state county]
  (some #(if (= county (:name %)) (:tax %)) (:counties state)))

(defn calculate-state-tax [state county amount]
  (if-let [county-tax (find-county-tax state county)]
    (double-to-precision (* amount (+ county-tax (:tax state))) 2 java.math.RoundingMode/HALF_UP)
    (* amount (:tax state))))

(defn calculate-total [state-name county amount]
  (let [total {:total (double amount)}]
    (if-let [state (find-state state-name)]
      (let [tax (calculate-state-tax state county amount)]
        (assoc total :total (+ amount tax) :tax tax))
      total)))


(def prompt-amount (make-int-prompt "What is the order amount?"))
(def prompt-state (make-string-prompt "What state do you live in?"))
(def prompt-county (make-string-prompt "What county do you live in?"))

(defn output-result [total]
  (if (:tax total)
    (println (str "The tax is $" (:tax total))))
  (println (str "The total is $" (:total total))))

(defn run []
  (let [amount (prompt-amount)
        state (s/lower-case(prompt-state))]
    (if (state-county-tax? state)
      (output-result (calculate-total state (s/lower-case (prompt-county)) amount))
      (output-result (calculate-total state nil amount)))))