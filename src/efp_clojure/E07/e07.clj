(ns efp-clojure.E07.e07
  (:require [efp-clojure.utils.prompt :refer :all]))

(def sq-feet-to-m2 0.09290304)

(defn area-from-dimensions
  [length width]
  (* length width))

(defn square-feet-to-square-meters
  [square-feet]
  (* square-feet sq-feet-to-m2))

(def prompt-length (make-int-prompt "What is the length of the room in feet?"))
(def prompt-width (make-int-prompt "What is the width of the room in feet?"))

(defn output-dimensions
  [length width]
  (println (str "You entered dimensions of " length " feet by " width " feet.")))

(defn output-results
  [sq-feet sq-meters]
  (println "The area is")
  (println (str sq-feet " square feet"))
  (println (str sq-meters " square meters")))

(defn run
  []
  (let [length (prompt-length)
        width (prompt-width)
        sq-feet (area-from-dimensions length width)
        sq-meters (square-feet-to-square-meters sq-feet)]
    (output-dimensions length width)
    (output-results sq-feet sq-meters)))