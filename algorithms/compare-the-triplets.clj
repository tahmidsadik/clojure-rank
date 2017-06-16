(require '[clojure.string :as str])

(defn handle-input []
  (->>
    (->
      (read-line)
      (str/split #"\s+"))
    (map #(Integer/parseInt %))))

(def alice-score (handle-input))
(def bob-score (handle-input))

;; creating a tuple of a1 b1, a2 b2, a3 b3
(defn get-comparison-points []
  (map #(cond
    (> (first %) (second %)) (list 1 0)
    (< (first %) (second %)) (list 0 1)
    (= (first %) (second %)) (list 0 0))
    (map vector alice-score bob-score)))

(defn mn []
  (let [alice-comparision-points (apply + (flatten(map #(take 1 %) (get-comparison-points))))
       bob-comparision-points (apply + (flatten (map #(take 1 (drop 1 %)) (get-comparison-points))))]
       (println alice-comparision-points bob-comparision-points)))

(mn)
