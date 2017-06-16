(require '[clojure.string :as str])

(defn take-input-line []
  (->>
   (->
    (read-line)
    (str/split #"\s+"))
   (map #(Integer/parseInt %))))

(def array-size (Integer/parseInt (read-line)))
(def input-array (take-input-line))

(def positive-nums (filter #(> % 0) input-array))
(def negative-nums (filter #(< % 0) input-array))
(def zeroes (filter #(= % 0) input-array))

(print
 (format "%.6f\n%.6f\n%.6f"
         (double (/ (count positive-nums) array-size))
         (double (/ (count negative-nums) array-size))
         (double (/ (count zeroes) array-size))))

