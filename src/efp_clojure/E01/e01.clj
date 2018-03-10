(ns efp-clojure.E01.e01)

(defn prompt-name
  "Prompts name from command-line"
  []
    (println "What is your name? ")
    (read-line)
  )

(defn greet
  "Make greeting string"
  [name]
  (str "Hello, " name ", nice to meet you!"))

(defn run
  "Run the program"
  []
  (println (greet (prompt-name))))