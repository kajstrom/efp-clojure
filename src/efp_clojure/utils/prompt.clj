(ns efp-clojure.utils.prompt)

(defn make-string-prompt
  [message]
  (fn []
    (println message)
    (read-line))
  )

(defn make-int-prompt
  [message]
  (fn []
    (println message)
    (Integer/parseInt (read-line))))