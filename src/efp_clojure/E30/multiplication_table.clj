(ns efp-clojure.E30.multiplication-table)

(defn multiplication-of
  [number]
   (for [x (range 0 (inc number))]
    (for [y (range 0 (inc number))]
      {:x x :y y :res (* x y)})))