(ns efp-clojure.E37.password-generator)

(def special-chars [\$ \^ \* \' \& \% \§ \# \?])

(defn- rand-str
  [len]
  (apply str (take len (repeatedly #(char (+ (rand 26) 97))))))

(defn generate-pw
  [length special-cnt numbers]
  (str
   (rand-str length)
   (apply str (repeatedly numbers #(rand-int 10)))
   (apply str(repeatedly special-cnt #(rand-nth special-chars)))))