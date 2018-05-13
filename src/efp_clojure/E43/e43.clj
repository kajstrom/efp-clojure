(ns efp-clojure.E43.e43
  (:require [efp-clojure.utils.prompt :refer :all]
            [clojure.java.io :refer [make-parents resource]]))

(def prompt-name (make-string-prompt "Site name:"))
(def prompt-author (make-string-prompt "Author:"))
(def prompt-js-folder (make-bool-prompt "Do you want a folder for JavaScript?"))
(def prompt-css-folder (make-bool-prompt "Do you want a folder for CSS?"))

(defn html-page
  [title author]
  (str "<html>
    <head>
      <title>" title "</title>
      <meta name=\"author\" content=\"" author "\">
      </head>
      <body></body>
      </html>"))

(defn run
  []
  (let [name (prompt-name)
        site-path name
        author (prompt-author)
        html (html-page name author)
        js-folder (prompt-js-folder)
        css-folder (prompt-css-folder)
        ]
    (println site-path)
    (make-parents (str site-path "\\index.html"))
    (spit (str site-path "\\index.html") html)
    (if js-folder
      (make-parents (str site-path "\\js\\files")))
    (if css-folder
      (make-parents (str site-path "\\css\\files")))))