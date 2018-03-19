(ns efp-clojure.E08.e08
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-people (make-int-prompt "How many people?"))
(def prompt-pizzas (make-int-prompt "How many pizzas do you have?"))
(def prompt-slices-per-pizza (make-int-prompt "How many slices per pizza?"))

(defn- output-results
  [slicing pizzas]
  (println (str (:persons slicing) " people with " pizzas " pizzas"))
  (println (str "Each person gets " (:per-person slicing) " pieces of pizza"))
  (println (str "There are " (:leftover slicing) " leftover pieces")))

(defn slices-per-person
  [pizzas slices-in-pizza persons]
  (let [slices (* pizzas slices-in-pizza)
         per-person (int (Math/floor (/ slices persons)))
        leftover (- slices (* per-person persons))]
    {:per-person per-person :leftover leftover :persons persons}))

(defn run
  []
  (let [
         people (prompt-people)
         pizzas (prompt-pizzas)
         slices-in-pizza (prompt-slices-per-pizza)
         slicing (slices-per-person pizzas slices-in-pizza people)]
    (output-results slicing pizzas)))