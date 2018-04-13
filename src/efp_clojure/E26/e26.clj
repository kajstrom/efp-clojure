(ns efp-clojure.E26.e26
  (:require [efp-clojure.utils.prompt :refer :all]
            [efp-clojure.E26.credit-card-debt :refer [months-until-paid-off]]))

(def prompt-balance (make-int-prompt "What is your balance?"))
(def prompt-apr (make-int-prompt "What is the APR on the card (as a percent)?"))
(def prompt-monthly-payment (make-int-prompt "What is the monthly payment you can make?"))

(defn run []
  (let [months (months-until-paid-off (prompt-balance) (prompt-apr) (prompt-monthly-payment))]
    (println "It will take you" months "months to pay of this card.")))