(ns efp-clojure.E10.e10
  (:require [efp-clojure.utils.prompt :refer :all]))

(defn prompt-item
  [number]
  {:price ((make-int-prompt (str "Enter the price of item " number ": ")))
   :quantity ((make-int-prompt (str "Enter the quantity of item " number ": ")))})

(defn item-total
  [item]
  (* (:price item) (:quantity item)))

(defn item-checkout
  [checkout item]
  (let [item-sub (item-total item)
        item-tax (* item-sub 0.055)]
    {:subtotal (+ (:subtotal checkout) item-sub)
      :tax (+ (:tax checkout) (* item-tax))
      :total (+ (:total checkout) (+ item-sub item-tax))
      }
    )
  )

(defn checkout-items [items]
  (reduce item-checkout {:subtotal 0 :tax 0 :total 0} items))

(defn output-checkout [checkout]
  (println (str "Subtotal: $" (:subtotal checkout)))
  (println (str "Tax: $" (:tax checkout)))
  (println (str "Total: $" (:total checkout))))

(defn run
  []
  (let [checkout (checkout-items (list (prompt-item 1) (prompt-item 2) (prompt-item 3)))]
    (output-checkout checkout)))