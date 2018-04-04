(ns efp-clojure.E19.e19
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.utils.number :refer :all])
  (:import java.math.RoundingMode))

(defn bmi
  "Calculate BMI"
  [height weight]
  (double-to-precision
   (*
      703
      (with-precision 10 :rounding RoundingMode/HALF_UP(/ weight (bigdec(* height height))))
      )
   1 RoundingMode/HALF_UP))

(defn bmi-desc
  [bmi]
  (str "Your BMI is " bmi ".\n" (cond
    (< bmi 18.5) "You are underweight. You should see a doctor."
    (> bmi 25) "You are overweight. You should see a doctor."
    :else "You are within the ideal weight range.")))

(def prompt-height (make-int-prompt "Enter your height in inches:"))
(def prompt-weight (make-int-prompt "Enter your weight in pounds:"))

(defn run
  []
  (println (bmi-desc (bmi (prompt-height) (prompt-weight)))))