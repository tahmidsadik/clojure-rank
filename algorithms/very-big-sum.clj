(require '[clojure.string :as str])

(defn handle-input []
  (->>
    (->
      (read-line)
      (str/split #"\s+"))
    (map #(Integer/parseInt %))))

(def array-size (read-line))

(println (apply + (handle-input)))
