(ns efp-clojure.E48.e48
  (:require
    [cheshire.core :as cs]
    [efp-clojure.utils.prompt :refer :all]))

(def prompt-location (make-string-prompt "Where are you?"))

(defn api-query
  [query]
  (let [url-encoded (clojure.string/replace query #" " "%20")]
    (try (slurp (str "http://api.openweathermap.org/data/2.5/weather?q=" url-encoded "&appid=eded185ba4eb988918dfbcaf8319e171&units=metric"))
      (catch java.io.FileNotFoundException e nil))))

(defn city-weather
  [city]
  (if-let [weather-json (api-query city)]
    (cs/parse-string weather-json true)
    nil))

(defn print-weather
  [weather]
  (if weather
    (do
      (println (:name weather) "weather:")
      (println (get-in weather [:main :temp]) "Celsius"))
    (println "Location not found..."))
  )

(defn run
  []
  (-> (prompt-location)
      city-weather
      print-weather))