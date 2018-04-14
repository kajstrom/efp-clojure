(ns efp-clojure.E27.e27
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E27.validation :refer [validate]]))

(def prompt-first-name (make-string-prompt "Enter the first name:"))
(def prompt-last-name (make-string-prompt "Enter the last name:"))
(def prompt-zip-code (make-string-prompt "Enter the ZIP code:"))
(def prompt-employee-id (make-string-prompt "Enter an employee ID:"))

(defn output-validation
  [errors]
  (if-not (empty? errors)
    (doseq [[k msg] errors]
      (println msg))
    (println "There were no errors found.")))

(defn run []
  (let [employee {:first-name (prompt-first-name)
                  :last-name (prompt-last-name)
                  :zip (prompt-zip-code)
                  :emp-id (prompt-employee-id)}]
    (output-validation(validate employee))))