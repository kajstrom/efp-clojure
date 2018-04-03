(ns efp-clojure.E18.e18
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-conversion-type (make-string-prompt "Enter C to convert Fahrenheit to Celsius and F to convert Celsius to Fahrenheit"))
(def prompt-fahrenheit (make-int-prompt "Temperature in Fahrenheit:"))
(def prompt-celsius (make-int-prompt "Temperature in Celsius:"))

(defn celsius-to-fahrenheit [celsius]
  (+ (* celsius (/ 9 5)) 32))

(defn fahrenheit-to-celsius [fahrenheit]
  (* (- fahrenheit 32) (/ 5 9)))

(defn output-celsius-conversion [celsius]
  (println (str "The temperature in Celsius is " (double celsius))))

(defn output-fahrenheit-conversion [fahrenheit]
  (println (str "The temperature in Fahrenheit is " (double fahrenheit))))

(defn run []
  (case (clojure.string/upper-case (prompt-conversion-type))
    "C" (output-celsius-conversion (fahrenheit-to-celsius (prompt-fahrenheit)))
    "F"(output-fahrenheit-conversion (celsius-to-fahrenheit (prompt-celsius)))
    (println "Unknown mode")))