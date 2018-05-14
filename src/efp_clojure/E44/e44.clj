(ns efp-clojure.E44.e44
  (:require
    [efp-clojure.utils.prompt :refer :all]
    [clojure.string :as s]
    [cheshire.core :refer :all]))

(def prompt-item-name (make-string-prompt "What is the product name?"))

(defn read-inventory
  [file]
  (cheshire.core/parse-string (slurp file)))

(defn search-product
  [inventory name]
  (first (filter #(= (s/lower-case name) (s/lower-case (get % "name"))) (get inventory "products"))))

(defn run
  []
  (let [inventory (read-inventory (clojure.java.io/resource "E44.json"))
        product (search-product inventory (prompt-item-name))]
    (if product
      (do
        (println "Name:" (get product "name"))
        (println (str "Price: $" (get product "price")))
        (println "Quantity on hand:" (get product "quantity")))
      (do
        (println "Sorry, that product was nopt found in our inventory")
        (run)))
    ))