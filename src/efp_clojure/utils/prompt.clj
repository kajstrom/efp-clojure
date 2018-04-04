(ns efp-clojure.utils.prompt)

(defn make-string-prompt
  [message]
  (fn []
    (println message)
    (read-line))
  )

(defn make-int-prompt
  [message]
  (fn prompt []
    (println message)
    (try (Integer/parseInt (clojure.string/trim (read-line)))
      (catch NumberFormatException e
        (println "Invalid input! Please enter a valid integer.")
        (prompt)))))

(defn make-double-prompt
  [message]
  (fn []
    (println message)
    (Double/parseDouble (read-line))))