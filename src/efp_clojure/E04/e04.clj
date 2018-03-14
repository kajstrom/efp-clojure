(ns efp-clojure.E04.e04)

(defn- prompt-noun
  []
  (println "Enter a noun: ")
  (read-line))

(defn- prompt-verb
  []
  (println "Enter a verb: ")
  (read-line))

(defn- prompt-adjective
  []
  (println "Enter an adjective: ")
  (read-line))

(defn- prompt-adverb
  []
  (println "Enter an adverb: ")
  (read-line))

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