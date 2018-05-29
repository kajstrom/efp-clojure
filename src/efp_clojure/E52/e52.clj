(ns efp-clojure.E52.e52
  (:require [ring.adapter.jetty :as jetty]
            [cheshire.core :as cs]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (cs/generate-string {"currentTime" (java.util.Date.)})})

(defonce server (jetty/run-jetty #'handler {:port 3000 :join? false}))