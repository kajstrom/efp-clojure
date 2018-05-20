(ns efp-clojure.E49.e49
  (:require
    [efp-clojure.utils.prompt :refer :all]
    [clojure.xml :as xml]))

(defn search-tag-images [tag]
  (filter
   #(= :entry (:tag %))
          (:content
                     (xml/parse (str "https://api.flickr.com/services/feeds/photos_public.gne?tags="tag)))))

(defn image-url [image]
  (->> image
       :content
      (filter #(= :link (:tag %)))
       (filter #(= "enclosure" (get-in % [:attrs :rel])))
       first
       :attrs
       :href
      ))

(defn make-html-doc [images]
  (str "<!DOCTYPE html>
  <html>
  <head>
  <title>images</title>
  </head>
  <body>
  "
       (clojure.string/join (map #(str "<div><img src=\"" %"\" /></div>") images))
  "</body>
  </html>"))


(def prompt-tag (make-string-prompt "Enter images to search for"))

(defn run
  []
  (->> (prompt-tag)
      search-tag-images
      (map image-url)
       make-html-doc
       (spit "images.html")))