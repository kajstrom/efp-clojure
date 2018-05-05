(ns efp-clojure.E41.e41
  (:require [clojure.string :as s]))

(defn run
  []
  (let [names (slurp (clojure.java.io/resource "E41_names.dat"))
        header (str "Total of " (count names) "names\n-----------------")]
    (spit "resources/E41_names.out" (s/join "\n" (sort (s/split-lines names))))))