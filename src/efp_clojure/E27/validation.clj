(ns efp-clojure.E27.validation)

(defn is-filled-in
  [s]
  ((complement empty?) s))

(defn is-2-chars-longs
  [s]
  (>= (count s) 2))

(defn is-valid-zip
  [s]
  (if (string? s)
    (some? (re-matches #"[0-9]{1,}" s))
    false))

(defn is-valid-emp-id
  [id]
  (if (string? id)
    (some? (re-matches #"[a-zA-Z]{2}\-[0-9]{4}" id))
    false))

(defn validate-first-name
  [employee errors]
  (let [first-name (:first-name employee)]
    (if-not (is-filled-in first-name)
    (assoc errors :first-name "The first name must be filled in.")
    (if-not (is-2-chars-longs first-name)
      (assoc errors :first-name (str "\" "first-name " \" is not a valid first name. It is too short."))
      errors))))

(defn validate-last-name
  [employee errors]
  (let [last-name (:last-name employee)]
    (if-not (is-filled-in last-name)
      (assoc errors :last-name "The last name must be filled in.")
      (if-not (is-2-chars-longs last-name)
        (assoc errors :last-name (str "\"" last-name "\" is not a valid last name. It is too short."))
        errors))))

(defn validate-zip
  [employee errors]
  (if-not (is-valid-zip (:zip employee))
    (assoc errors :zip "The ZIP code must be numeric")
    errors))

(defn validate-emp-id
  [employee errors]
  (if-not (is-valid-emp-id (:emp-id employee))
    (assoc errors :emp-id (str (:emp-id employee) " is not a valid ID."))
    errors))

(defn validate
  [employee]
  (->> {}
      (validate-first-name employee)
       (validate-last-name employee)
       (validate-zip employee)
       (validate-emp-id employee)))