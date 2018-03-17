(ns efp-clojure.E05.e05)

(defn- prompt-first-number
  []
  (println"What is the first number? ")
  (Integer/parseInt (read-line)))

(defn- prompt-second-number
  []
  (println "What is the second number? ")
  (Integer/parseInt (read-line)))

(defn calculations
  [first second]
  (list
   (str first " + " second " = " (+ first second))
   (str first " - " second " = " (- first second))
   (str first " * " second " = " (* first second))
   (str first " / " second " = " (/ first second))))

(defn run
  []
  (doseq [res (calculations (prompt-first-number) (prompt-second-number))]
    (println res)))