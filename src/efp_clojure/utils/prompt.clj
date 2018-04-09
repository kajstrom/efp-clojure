(ns efp-clojure.utils.prompt
  (:require [clojure.string :as s]))

(defn make-string-prompt
  [message]
  (fn []
    (println message)
    (read-line))
  )

(def truthy '("yes" "y"))
(def falsy '("no" "n"))

(defn in?
  [v coll]
  (some #(= v %) coll))

(defn make-bool-prompt
  "Makes a prompt for boolean y/n yes/no prompts"
  [message]
  (fn prompt []
    (println message)
    (let [resp (s/lower-case (s/trim (read-line)))]
      (if (in? resp truthy)
        true
        (if (in? resp falsy)
          false
          (do
            (println (str "Invalid input. Please enter a valid input: " (s/join ", " truthy) ", " (s/join ", " falsy)))
            (prompt)))))))

(defn make-int-prompt
  [message]
  (fn prompt []
    (println message)
    (try (Integer/parseInt (s/trim (read-line)))
      (catch NumberFormatException e
        (println "Invalid input! Please enter a valid integer.")
        (prompt)))))

(defn make-double-prompt
  [message]
  (fn []
    (println message)
    (Double/parseDouble (read-line))))

(defn make-output
  [message]
  (fn []
    (println message)))