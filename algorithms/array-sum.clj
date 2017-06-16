(require '[clojure.string :as str])

(def array-size (Integer/parseInt (read-line)))

(->> (->
  (read-line)
  (str/split #"\s+"))
  (map #(Integer/parseInt %))
  (apply +)
  (println))


;
; (println(apply + (map #(Integer/parseInt %) (str/split (read-line) #"\s+"))))
