(ns efp-clojure.E51.e51
  (:require
    [cheshire.core :as cs]
    [clj-http.client :as http-client]
    [efp-clojure.utils.prompt :refer :all]))

(def api-url "https://exercises-for-programmers.firebaseio.com/notebooks/mynotes.json")

(def prompt-command (make-string-prompt ""))

(defn add-note! [note]
  (http-client/post api-url {:body (cs/generate-string {"content" note})}))

(defn get-notes []
  (cs/parse-string (:body (http-client/get api-url))))

(defn print-notes [notes]
  (doseq [note (vals notes)]
    (println (get note "content"))))

(defn parse-input [input]
  (let [splitted (clojure.string/split input #" ")
        command (first splitted)
        params (clojure.string/join " "(rest splitted) )]
    (case command
      "new" {:command :new :params params}
      "show" {:command :show :params params}
      {:command nil})))

(defn run []
  (println "'new' adds a new note. 'show' lists existing notes")
  (let [command (parse-input(prompt-command))]
    (case (:command command)
      :new (do
             (add-note! (:params command))
             (println "Note added"))
      :show (print-notes (get-notes))
      (println "Invalid command" command))))