(ns efp-clojure.E41.e41
  (:require [clojure.string :as s]))

(defn run
  []
  (let [names (s/split-lines (slurp (clojure.java.io/resource "E41_names.dat")))
        header (str "Total of " (count names) " names\n-----------------\n\n")]
    (spit "resources/E41_names.out" (str header (s/join "\n" (sort names))))))