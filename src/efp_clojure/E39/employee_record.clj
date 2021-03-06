(ns efp-clojure.E39.employee-record
  (:require [clojure.string :as s]))

(def employees (list
                {:first-name "John" :last-name "Johnson" :position "Manager" :sep-date "2016-12-31"}
                {:first-name "Tou" :last-name "Xiong" :position "Software Engineer" :sep-date "2016-10-05"}
                {:first-name "Michaela" :last-name "Michaelson" :position "District Manager" :sep-date "2015-12-19"}
                {:first-name "Jake" :last-name "Jacobson" :position "Programmer" :sep-date nil}
                {:first-name "Jacquelyn" :last-name "Jackson" :position "DBA" :sep-date nil}
                {:first-name "Sally" :last-name "Weber" :position "Web Developer" :sep-date "2015-12-18"}))

(defn format-for-printing
  [employees]
  (map #(hash-map "Name" (str (:first-name %) " " (:last-name %))
         "Position" (:position %)
         "Separation Date" (:sep-date %)) (sort-by :last-name employees)))

(defn filter-by-name
  [employees name]
  (filter  #(or (s/includes? (:first-name %) name) (s/includes? (:last-name %) name)) employees))