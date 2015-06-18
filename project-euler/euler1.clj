;; Find the sum of multiples of 3 and 5 below n

;; This is elegant but inefficient ... Maybe efficient is elegant ... or Maybe My head is playing with me

;; (defn multiples-of-x-below-n [x]
  ;; (fn [n]
    ;; (range x n x)))

;; (defn sol [n]
  ;; (apply + (set (concat ((multiples-of-x-below-n 3) n) ((multiples-of-x-below-n 5) n)))))


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

(defn sub-15 [n s]
  (loop [sum s a 15]
    (if (>= a n) sum
        (recur (- sum a) (+ a 15)))))

(defn sol2 [n]
  (sub-15 n (+ (for-3 n) (tem-5 n))))

(defn for-5 [^long n]
  (loop [sum 0 x 5]
    (if (>= x n) sum
        (if (evenly-divisilble-by-3? x) (recur sum (+ x 5))
          (recur (+ sum x) (+ 5 x))))))

(defn sol [n]
  (+ (for-3 n) (for-5 n)))

(defn)





(loop [number-of-test-case (Integer/parseInt (read-line))]
  (if (= 0 number-of-test-case) nil
      (do (println (sol (Integer/parseInt (read-line))))
          (recur (dec number-of-test-case)))))


(time (sol 1000000000))
