(ns efp-clojure.E03.e03)

(defn prompt-quote
  "Prompts the user for a quote"
  []
  (println "What is the quote?")
  (read-line))

(defn prompt-originator
  "Prompts the user for the originator of the quote"
  []
  (println "Who said it?")
  (read-line))

(defn quote-originator
  "Create quote"
  [quote originator]
  (str originator " says, " "\"" quote "\""))

(defn run
  "Run program"
  []
  (println (quote-originator (prompt-quote) (prompt-originator))))