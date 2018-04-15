(ns efp-clojure.E29.e29
  (:require [efp-clojure.utils.prompt :refer :all]))

(defn prompt-rate
  []
    (println "What is the rate of return?")
  (try (let [val (Integer/parseInt (clojure.string/trim (read-line)))]
         (if-not (= 0 val)
           val
           (do
             (println "0 is an invalid rate!")
             (prompt-rate))))
    (catch NumberFormatException e
               (println "Sorry. That's not a valid input.")
               (prompt-rate))))


(defn calc-investment-doubling-years
  [rate]
  (int (/ 72 rate)))

(defn run
  []
  (println "It will take" (calc-investment-doubling-years (prompt-rate)) "years to double your initial investment."))