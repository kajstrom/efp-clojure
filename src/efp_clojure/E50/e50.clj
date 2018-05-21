(ns efp-clojure.E50.e50
  (:require
    [efp-clojure.utils.prompt :refer :all]
    [cheshire.core :as cs]
    [ring.util.codec :refer [url-encode]]))

(def prompt-movie (make-string-prompt "Enter the name of a movie"))

(defn print-movie [movie]
  (println "Title:" (:Title movie))
  (println "Year:" (:Year movie))
  (println "Rating:" (:Rated movie))
  (println "Running Time:" (:Runtime movie))
  (println "Genre:" (:Genre movie))
  (println "Description:" (:Plot movie)))

(defn search-movie [name]
  (cs/parse-string (->> name
                        url-encode
      (str "http://www.omdbapi.com/?apikey=216e6b71&t=")
       slurp) true))

(defn run []
  (let [name (prompt-movie)
        movie (search-movie name)]
    (if (= "True" (:Response movie))
      (print-movie movie)
      (println "No movie found with name" name))))