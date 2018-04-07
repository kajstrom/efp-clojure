(ns efp-clojure.E21.e21
  (:require [efp-clojure.utils.prompt :refer :all]))

(def months {1 "January" 2 "February" 3 "March" 4 "April" 5 "May" 6 "June" 7 "July" 8 "August" 9 "September" 10 "October" 11 "November" 12 "December"})

(def prompt-month-number (make-int-prompt "Please enter the number of the month:"))

(defn run []
  (if-let [month (get months (prompt-month-number))]
    (println (str "The name of the month is " month))
    (println "No month found with that number")))