(ns efp-clojure.E47.e47
  (:require
    [cheshire.core :refer :all]))

(defn fetch-astronauts
  []
  ;; The future here is mostly useless in this case, just wanted to give it a try
  (future (slurp "http://api.open-notify.org/astros.json")))

(defn print-astronauts
  [astronauts]
  (println "There are" (count astronauts) "people in space right now:")
  (clojure.pprint/print-table astronauts))

(defn run
  []
  (print-astronauts (get (cheshire.core/parse-string @(fetch-astronauts)) "people")))