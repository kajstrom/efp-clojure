(ns efp-clojure.E35.e35
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E35.winner-picker :refer :all]))

(def prompt-contenstant (make-string-prompt "Enter a name:"))

(defn prompt-contestants []
  (let [contestant (prompt-contenstant)]
    (if (< 0 (count contestant))
      (do
        (add-contestant contestant)
        (prompt-contestants))
      )))

(defn run
  []
  (prompt-contestants)
  (println "The winner is..." (pick-winner)))