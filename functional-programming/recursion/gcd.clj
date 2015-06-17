(defn gcd [big small]
  (let [remainder (rem big small)]
    (if (zero? remainder) small (recur small remainder))))

(gcd 8 12)

(map read-string (re-seq #"\d+" "1 2 3"))
