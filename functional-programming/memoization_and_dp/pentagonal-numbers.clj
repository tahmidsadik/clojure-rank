(def pentagonal (memoize (fn [n sum a]
                           (cond
                            (> a n) (cond
                                     (= n 1) 1
                                     (= n 2) 5
                                     :else sum)
                            (= a 1) (recur n (+ 1 sum) (inc a))
                            (= a 2) (recur n (+ 4 sum) (inc a))
                            :else (recur n (+ sum (inc (* 3 (dec a)))) (inc a))))))

(dotimes [i (Integer/parseInt (read-line))]
  (println (pentagonal (Integer/parseInt (read-line)) 0 1)))

(pentagonal 5 0 1)

