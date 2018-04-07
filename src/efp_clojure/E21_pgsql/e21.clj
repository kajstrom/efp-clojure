(ns efp-clojure.E21-pgsql.e21
  (:require [clojure.java.jdbc :as j]
            [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.utils.pgsql :refer [pg-db]]))

(def prompt-month-number (make-int-prompt "Please enter the number of the month:"))

(defn find-month [number]
  (first (j/query pg-db ["SELECT * FROM e21_months WHERE number = ?" number])))

(defn run []
  (if-let [month (find-month (prompt-month-number))]
    (println (str "The name of the month is " (:name month)))
    (println "There is no month with that number!")))