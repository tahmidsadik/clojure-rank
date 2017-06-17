(require '[clojure.string :as str])

(def input-values (map #(Integer/parseInt %) (str/split (read-line) #"\s+")))

(defn drop-nth [n coll]
  (keep-indexed #(if (not= %1 n) %2 nil) coll))

(defn one-less-combination
  "returns every combination of dropping one element from a seq"
  [coll]
  (for [i (range 0 (count coll))]
    (drop-nth i coll)))

(def summation-of-combs (map #(apply + %) (one-less-combination input-values)))

(print (apply min summation-of-combs) (apply max summation-of-combs))
