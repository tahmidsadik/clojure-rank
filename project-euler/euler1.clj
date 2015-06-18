(defn find-sum-of-multiples-upto-n [^long n ^long a]
  (let [m (quot (dec n) a)]
    (quot (* a m (inc m)) 2)))

(defn sol [^long n]
  (- (+ (find-sum-of-multiples-upto-n n 3) (find-sum-of-multiples-upto-n n 5)) (find-sum-of-multiples-upto-n n 15)))

(loop [number-of-test-case (Integer/parseInt (read-line))]
  (if (= 0 number-of-test-case) nil
      (do (println (sol (Integer/parseInt (read-line))))
          (recur (dec number-of-test-case)))))
