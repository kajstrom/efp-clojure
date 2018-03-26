(ns efp-clojure.utils.number)

(defn double-to-precision [val precision rounding-mode]
  (.doubleValue (.setScale (bigdec val) precision rounding-mode)))