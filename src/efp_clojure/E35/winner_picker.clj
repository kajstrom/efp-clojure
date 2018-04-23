(ns efp-clojure.E35.winner-picker)

(def contestants (atom (list)))

(defn add-contestant
  [contestant]
  (swap! contestants conj contestant))

(defn pick-winner
  []
  (rand-nth @contestants))