(ns efp-clojure.E26.credit-card-debt)

(defn months-until-paid-off
  [balance apr monthly-payment]
  (int (Math/ceil(*(- (/ 1 30))
    (let [daily-rate (/ apr 36500)]
      (/ (Math/log (+ 1 (* (/ balance monthly-payment) (- 1 (Math/pow (+ 1 daily-rate) 30)))))
         (Math/log (+ 1 daily-rate))))))))