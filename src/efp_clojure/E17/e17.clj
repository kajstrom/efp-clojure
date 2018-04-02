(ns efp-clojure.E17.e17
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.utils.number :refer :all]))

(defn alcohol-distribution-ratio [sex]
  (if (= "W" sex)
    0.66
    0.73))

(defn calc-bac [person drinks]
  (double-to-precision (-
   (/ (* (:amount-oz drinks) 5.14) (* (:weight person) (alcohol-distribution-ratio (:sex person))))
   (* 0.015 (:hours-since-last drinks))) 2 java.math.RoundingMode/HALF_UP))

(def prompt-weight (make-int-prompt "How much do you weigh?"))
(def prompt-sex (make-string-prompt "What is your gender? (W/M)"))
(def prompt-alc-amount (make-int-prompt "How much alcohol in ounces did you consume?"))
(def prompt-hours-since-last (make-int-prompt "How many hours has it been since your last drink?"))

(defn output-result [bac]
  (println (str "Your BAC is " bac))
  (if (>= bac 0.08)
    (println "It is not legal for you to drive!")
    (println "It is legal for you to drive.")))

(defn run []
  (output-result (calc-bac
                  {:weight (prompt-weight) :sex (prompt-sex)}
                  {:amount-oz (prompt-alc-amount) :hours-since-last (prompt-hours-since-last) }
                  )))