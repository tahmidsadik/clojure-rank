(def fib (memoize (fn [^long n a b]
            (cond
             (= n 0) a
             :else (recur (dec n) b (+' a b))))))

(defn sol [n]
  (apply +' (loop [fibos '() a 0]
     (let [current-fibo (fib a 0 1)]
       (if (> current-fibo n) fibos
           (recur (if (even? current-fibo)
                    (cons current-fibo fibos)
                    fibos) (inc a)))))))

(dotimes [i (Integer/parseInt (read-line))]
  (println (sol (Integer/parseInt (read-line)))))
