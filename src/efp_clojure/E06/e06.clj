(ns efp-clojure.E06.e06
  (:require [efp-clojure.utils.prompt :refer :all])
  (:import (java.time LocalDate)))

(def prompt-age (make-int-prompt "What is your current age?"))

(def prompt-retirement-age (make-int-prompt "At what age would you like to retire?"))

(defn calc-years-to-retirement
  "Calculates years to retirement"
  [age retirement-age ]
  (- retirement-age age))

(defn calc-year-to-retire
  "Calculates the year to retire in"
  [years-to-retirement current-year]
  (+ years-to-retirement current-year))

(defn run
  []
  (let [years-to-retirement (calc-years-to-retirement (prompt-age) (prompt-retirement-age))
        year-to-retire-in (calc-year-to-retire years-to-retirement (.getYear (java.time.LocalDate/now)))]
    (if (< years-to-retirement 0)
      (println "You can already retire!")
      (do
        (println (str "You have " years-to-retirement " years left until you can retire"))
        (println (str "It's 2018, so you can retire in " year-to-retire-in)))
      )))