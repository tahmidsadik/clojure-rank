(defn fib
  "Returns nth fibonacci number"
  [n]
  (let [first 0 second 1]
    (cond (= n 1) first
          (= n 2) second
          :else (loop [a first b second th 3]
                  (if (= th n)
                    (+ a b)
                    (recur b (+ a b) (inc th)))))))
(fib 9)

