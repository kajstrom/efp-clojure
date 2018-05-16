(ns efp-clojure.E45.e45
  (:require
    [efp-clojure.utils.prompt :refer :all]))

(def prompt-file-name (make-string-prompt "Enter the name of the output file:"))

(defn run
  []
  (let [out-file (prompt-file-name)]
    (spit out-file (clojure.string/replace (slurp (clojure.java.io/resource "E45.dat")) "utilize" "use"))))