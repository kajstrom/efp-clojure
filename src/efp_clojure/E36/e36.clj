(ns efp-clojure.E36.e36
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E36.statistics :refer [statistics]]))

(def numbers (atom []))

(def prompt-a-number (make-string-prompt "Enter a number:"))

(defn prompt-numbers
  []
  (let [number (prompt-a-number)]
    (if (not= "done" number)
      (try
        (swap! numbers  conj(Integer/parseInt number))
        (prompt-numbers)
        (catch NumberFormatException e
          (println "Invalid number!")
          (prompt-numbers))))))

(defn output-statistics
  [stats]
  (println "The average is" (:average stats))
  (println "The minimum is" (:minimum stats))
  (println "The maximum is" (:maximum stats))
  (println "The standard deviation" (:std-deviation stats)))

(defn run
  []
  (prompt-numbers)
  (output-statistics (statistics @numbers)))