(ns efp-clojure.E52.client
  (:require [cheshire.core :as cs]
            [clj-time.format :as tf]))

(defn print-time []
  (let [response (cs/parse-string (slurp "http://localhost:3000") true)
        time (tf/parse (:currentTime response))
        format (tf/formatter "hh:mm:ss 'UTC' d.M.Y")]
    (println  "The current time is" (tf/unparse format time))))