(def input (Integer/parseInt (read-line)))
(defn get-triangle-val [row col]
  (cond (= col 1) 1
        (= row col) 1
        :else (+ (get-triangle-val (dec row) (dec col)) (get-triangle-val (dec row) col))))

(defn print-pascal-triangle [n]
  (doseq [i (reverse (loop [start 1 limit n vals '()]
                        (if (> start limit)
                          vals
                          (recur (inc start)
                                 limit
                                 (conj vals (map #(get-triangle-val start %) (range 1 (inc start))))))))] (apply println i)))

(print-pascal-triangle input)
           ;;                             1
           ;;                           1   1
           ;;                         1   2   1
           ;;                       1   3   3   1
           ;;                     1   4   6   4   1
