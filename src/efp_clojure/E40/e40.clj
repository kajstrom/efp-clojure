(ns efp-clojure.E40.e40
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E39.employee-record :refer :all]))

(def prompt-search-string (make-string-prompt "Enter a search string: "))

(defn run
  []
  (let [name (prompt-search-string)]
    (println "Results:")
    (clojure.pprint/print-table (format-for-printing (filter-by-name employees name)))))