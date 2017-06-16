(require '[clojure.string :as str])

(def array-size (Integer/parseInt (read-line)))

(defn take-input-line []
  (->>
   (->
    (read-line)
    (str/split #"\s+"))
   (map #(Integer/parseInt %))))

(def arr (for [i (range 0 array-size)]
           (take-input-line)))

(defn get-ltr-diag [input-arr]
  (apply + (flatten (for [i (range 0 (count input-arr))]
              (take 1 (drop i (nth input-arr i)))))))

(print (Math/abs (- (get-ltr-diag arr) (get-ltr-diag (map reverse arr)))))
