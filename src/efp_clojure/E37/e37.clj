(ns efp-clojure.E37.e37
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E37.password-generator :refer [generate-pw]]))

(def prompt-min-length (make-int-prompt "What's the minimum length?"))
(def prompt-special-chars (make-int-prompt "How many special chars?"))
(def prompt-numbers (make-int-prompt "How many numbers?"))

(defn run
  []
  (let [length (prompt-min-length)
        special-chars (prompt-special-chars)
        numbers (prompt-numbers)]
    (println "Your password is" (generate-pw length special-chars numbers))))