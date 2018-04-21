(ns efp-clojure.E34.e34
  (:require [efp-clojure.utils.prompt :refer :all]))

(def employees (atom ["John Smith" "Jackie Jackson" "Chris Jones" "Amanda Cullen" "Jeremy Goodwin"]))

(defn delete-employee
  [name]
  (swap! employees (fn [employees] (remove #(= name %) employees))))

(defn find-employee
  [name]
  (first (filter #(= name %) @employees)))

(def prompt-employee-to-delete (make-string-prompt "Enter an employee name to remove:"))

(defn print-employees
  []
  (let [employees @employees]
    (println "There are" (count employees) "employees")
    (doseq [employee employees]
    (println employee))))

(defn run
  []
  (print-employees)
  (let [emp-to-del (prompt-employee-to-delete)]
    (if (find-employee emp-to-del)
      (delete-employee emp-to-del)
      (println "No employee with name" emp-to-del)))
  (print-employees))