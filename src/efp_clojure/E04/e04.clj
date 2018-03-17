(ns efp-clojure.E04.e04
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-noun (make-string-prompt "Enter noun: "))

(def prompt-verb (make-string-prompt "Enter a verb: "))

(def prompt-adjective (make-string-prompt "Enter an adjective: "))

(def prompt-adverb (make-string-prompt "Enter an adverb: "))

(defn mad-lib
  "Creates a story from the provided words"
  [noun verb adjective adverb]
  (str "Do you " verb " your " adjective " " noun " " adverb "? That's hilarious!"))

(defn run
  []
  (let [noun (prompt-noun)
        verb (prompt-verb)
        adjective (prompt-adjective)
        adverb (prompt-adverb)]
    (println (mad-lib noun verb adjective adverb))))