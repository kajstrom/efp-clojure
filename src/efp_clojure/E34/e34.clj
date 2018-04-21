(ns efp-clojure.E34.e34
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E34.employee-list :refer :all]))

(def prompt-employee-to-delete (make-string-prompt "Enter an employee name to remove:"))

(defn print-employees
  []
  (let [employees @employees]
    (println "There are" (count employees) "employees")
    (doseq [employee employees]
    (println employee))))

(defn run
  []
  (load-employees)
  (print-employees)
  (let [emp-to-del (prompt-employee-to-delete)]
    (if (find-employee emp-to-del)
      (delete-employee emp-to-del)
      (println "No employee with name" emp-to-del)))
  (print-employees))