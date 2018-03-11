(ns efp-clojure.E02.e02)

(defn prompt-string
  "Prompts for a string"
  []
  (println "What is the input string? ")
  (read-line))

(defn desc-string-length
  "Create textual description of string lenght"
  [string]
  (str string " has " (count string) " characters."))