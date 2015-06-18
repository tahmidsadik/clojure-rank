;; Find the sum of multiples of 3 and 5 below n

(set! *warn-on-reflection* true)

(defn evenly-divisilble-by-15? [n]
  (if (zero? (rem n 15)) true false))

(defn for-3 [^long n]
  (loop [sum 0 x 3]
    (if (>= x n) sum
        (recur (+ sum x) (+ x 3)))))

(defn tem-5 [^long n]
  (loop [sum 0 x 5]
    (if (>= x n) sum
        (recur (+ sum x) (+ x 5)))))

(defn sub-15 [^long n ^long s]
  (loop [sum s a 15]
    (if (>= a n) sum
        (recur (- sum a) (+ a 15)))))

(defn for-5 [^long n]
  (loop [sum 0 x 5]
    (if (>= x n) sum
        (if (evenly-divisilble-by-15? x) (recur sum (+ x 5))
          (recur (+ sum x) (+ 5 x))))))

(defn smart-5 [^long n]
  (loop [sum 0 step 1 a 0]
    (if (>= a n) sum
        (if (not= step 3)
          (recur (+ sum a) (inc step) (+ a 5))
          (recur (+ sum 1) 1 (+ a 10))))))

(def limit 1000000000)

(defn sol [^long n]
  (+ (for-3 n) (for-5 n)))

(defn sol2 [^long n]
  (sub-15 n (+ (for-3 n) (tem-5 n))))

(defn sol3 [^long n]
  (+ (for-3 n) (smart-5 n)))

(loop [number-of-test-case (Integer/parseInt (read-line))]
  (if (= 0 number-of-test-case) nil
      (do (println (sol (Integer/parseInt (read-line))))
          (recur (dec number-of-test-case)))))

(time (sol limit))
(time (sol2 limit))
(time (sol3 limit))
