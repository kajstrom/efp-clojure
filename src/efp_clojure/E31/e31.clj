(ns efp-clojure.E31.e31
  (:require [efp-clojure.utils.prompt :refer :all]
            [clojure.pprint :refer [print-table]]
            [efp-clojure.E31.heart-rate :refer [intensity-hr-table hr-max]]))

(def prompt-resting-hr (make-int-prompt "What is your resting pulse?"))
(def prompt-age (make-int-prompt "What is your age?"))

(defn format-for-printing
  [intensity-table]
  (map #(hash-map "Intensity" (:intensity %) "Rate" (:rate %)) intensity-table))

(defn run
  []
  (let [age (prompt-age)
        resting-hr (prompt-resting-hr)
        hr-max (hr-max age)]
    (println "Resting Pulse:" resting-hr "Age:" age)
    (print-table (format-for-printing (intensity-hr-table hr-max resting-hr)))))