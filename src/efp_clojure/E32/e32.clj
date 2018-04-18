(ns efp-clojure.E32.e32
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E32.guess-number :refer :all]))

(defn prompt-difficulty
  []
  (let [prompt (make-int-prompt "Pick a difficulty level (1, 2, or 3)")
        difficulty-level (prompt)]
    (if (or (= difficulty-level 1) (= difficulty-level 2) (= difficulty-level 3))
      difficulty-level
      (do
        (println "Invalid difficulty level")
        (prompt-difficulty)))))

(def guess-first-number (make-int-prompt "I have my number. What's your guess?"))
(def guess-too-low (make-int-prompt "Too low. Guess again."))
(def guess-too-high (make-int-prompt "Too high. Guess again."))

(defn start-game
  []
  (println "Let's play Guess the Number.")
  ())