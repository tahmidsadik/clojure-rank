(defn remove-duplicates [s]
  (loop [final-string '() states {} c s]
    (let [current-char (first c)]
      (if (nil? current-char) (apply str (reverse final-string))
          (if (nil? (get states current-char))
            (recur (cons current-char final-string)
                   (assoc states current-char 1)
                   (rest c))
            (recur final-string states (rest c)))))))

(println (remove-duplicates (read-line)))
