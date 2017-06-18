(require '[clojure.string :as str])

(def number-of-candles (Integer/parseInt (read-line)))
(def candle-heights (map #(Integer/parseInt %) (str/split (read-line) #"\s+")))

(def max-height (apply max candle-heights))
(print (count (filter #(= % max-height) candle-heights)))
