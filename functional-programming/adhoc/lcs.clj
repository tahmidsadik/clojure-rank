(require '[clojure.string :as str])
(read-line)

(defn gcd [big small]
  (let [remainder (rem big small)]
    (if (zero? remainder) small (recur small remainder))))

(defn lcs-from-gcd [a b]
  (let [big (max a b) small (min a b)]
    (* (quot a (gcd big small)) b)))

(println (reduce lcs-from-gcd (map #(Integer/parseInt %) (str/split (read-line) #" "))))
