(ns efp-clojure.E32.guess-number)

(def answer (atom nil))
(def guess-cnt (atom 0))

(defn pick-answer
  [difficulty-level]
  (reset! guess-cnt 0)
  (case difficulty-level
    1 (reset! answer (inc (rand-int  10)))
    2 (reset! answer (inc (rand-int 100)))
    3 (reset! answer (inc (rand-int  1000)))))

(defn guess
  [number]
  (swap! guess-cnt inc)
  (cond
    (< number @answer) :low
    (> number @answer) :high
    :else :correct))