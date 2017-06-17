(def staircase-len (Integer/parseInt (read-line)))

(defn print-space
  "prints space n times"
  [n]
  (doseq [i (range n)]
        (print " ")))

(defn print-hash
  "prints # n times"
  [n]
  (doseq [i (range n)]
    (print "#")))


(defn staircase []
  (loop [x 0]
    (if (> x staircase-len)
      (print "")
      (do
        ;(print-space (- staircase-len x))
        ;(print-hash x)
        ;(print "\n")
        (recur (inc x))))))

(staircase)
(do
  (print-space 3)
  (print-hash 1)
  (print "\n"))

(defn get-char-times
  "returns a character n times concatenated"
  [char n]
  (loop [acc "" i 0]
    (when (= i n)
      acc
      (recur (str acc char) (inc i)))))

(get-char-times "#" 3)
