(ns efp-clojure.E09.e09
  (:require [efp-clojure.utils.prompt :refer :all]))

(def SQ_FEET_PER_GALLON 350)

(def prompt-width (make-int-prompt "What is the width of the room?"))
(def prompt-length (make-int-prompt "What is the length of the room?"))

(defn room-area
  [room]
  (* (:width room) (:length room)))

(defn output-result
  [paint room]
  (println (str "You will need to purchase " paint " gallons of paint to cover "
                (room-area room) " square feet")))

(defn calc-paint-amount
  [room]
  (int (Math/ceil (/ (room-area room) SQ_FEET_PER_GALLON))))

(defn run
  []
  (let [room {:width (prompt-width) :length (prompt-length)}]
    (output-result (calc-paint-amount room) room)))