(require '[clojure.string :as str])

(def given-time (read-line))

(defn to-24-hour-fmt [hour period]
  (let [h (Integer/parseInt hour)]
    (cond
     (and (= period "AM") (= h 12)) "00"
     (and (= period "AM") (not= h 12)) hour
     (and (= period "PM") (= h 12)) hour
     (and (= period "PM") (not= h 12)) (str (+ h 12))
     :else nil)))

(defn to-military
  "converts a 12 hour time format to military format"
  [time-str]
  (let [hour (first (str/split time-str #":"))
        minute (second (str/split time-str #":"))
        sec (apply str (take 2 (nth (str/split time-str #":") 2)))
        period (apply str(take 2 (drop 2 (nth (str/split time-str #":") 2))))
        ]
    (str (format "%s:%s:%s" (to-24-hour-fmt hour period) minute sec))))

(print (to-military given-time))
