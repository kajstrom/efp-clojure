(ns efp-clojure.E28.e28)

(defn prompt-numbers
  [numbers]
  (println "Enter a number:")
  (let [n (clojure.string/trim (read-line))]
    (try (prompt-numbers (conj numbers (Integer/parseInt n)))
      (catch NumberFormatException e
        numbers))))

(defn run
  []
  (let [sum (apply + (prompt-numbers (list)))]
    (println "The total is" sum ".")))