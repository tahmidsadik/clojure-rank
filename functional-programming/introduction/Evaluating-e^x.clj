(loop [test-case-remaining (Integer/parseInt (read-line))]
  (if (= 0 test-case-remaining)
    values
    (do (println (let [factorial (fn [n]
                                   (loop [acc n result 1]
                                     (if (= acc 0)
                                       result
                                       (recur (dec acc) (* result acc)))))
                       to-the-power (fn [n power]
                                      (loop [result n x power]
                                        (if (<= x 1)
                                          result
                                          (recur (* result n) (dec x)))))
                       e-to-the-power-x (fn [x]
                                          (inc (apply + (map #(float (/ (to-the-power x %)
                                                                        (factorial %)))
                                                             (range 1 10)))))]
                   (println (e-to-the-power-x (Float/parseFloat (read-line))))))
        (recur (dec test-case-remaining)))))
