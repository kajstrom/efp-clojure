(ns efp-clojure.E34.employee-list)

(def employees (atom nil))

(defn delete-employee
  [name]
  (swap! employees (fn [employees] (remove #(= name %) employees))))

(defn find-employee
  [name]
  (first (filter #(= name %) @employees)))

(defn load-employees
  []
  (reset! employees (clojure.string/split-lines (slurp (clojure.java.io/resource "employees.dat")))))