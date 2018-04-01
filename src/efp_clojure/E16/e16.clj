(ns efp-clojure.E16.e16
  (:require [efp-clojure.utils.prompt :refer :all]))

(def prompt-age (make-int-prompt "What is your age?"))
(def country-driving-ages (list {:country "United States" :driving-age 16} {:country "Finland" :driving-age 18} {:country "Sweden" :driving-age 18}))

(defn countries-allowed-to-drive-at-age [age]
  (filter #(>= age (:driving-age %)) country-driving-ages))

(defn output-results [countries]
  (if (not-empty countries)
    (do
      (println "You are allowed to drive in:")
      (doseq [country countries] (println (:country country)))
      )
    (println "You aren't allowed to drive anywhere!")))

(defn run []
  (output-results (countries-allowed-to-drive-at-age (prompt-age))))