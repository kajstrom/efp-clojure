(ns efp-clojure.utils.prompt)

(defn make-string-prompt
  [message]
  (fn []
    (println message)
    (read-line))
  )