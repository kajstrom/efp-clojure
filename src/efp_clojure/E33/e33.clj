(ns efp-clojure.E33.e33
  (:require [efp-clojure.utils.prompt :refer :all]))

(def answers ["Yes" "No" "Maybe" "Ask again later."])

(defn random-answer
  []
  (get answers (rand-int 4)))

(def prompt-question (make-string-prompt "What's your question?"))

(defn run
  []
  (prompt-question)
  (println (random-answer)))