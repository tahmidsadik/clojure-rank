(require '[clojure.string :as str])

(def number-of-points (Integer/parseInt (read-line)))

(defn take-input-line []
  (->>
   (->
    (read-line)
    (str/split #"\s+"))
   (map #(Integer/parseInt %))))

(defn square [n]
  (* n n))

(def points
  (for [i (range number-of-points)]
    (take-input-line)))

(defn get-distance-between-two-points
  "calculates the distance between two points p1 and p2 in a xy co-ordinate system"
  ;; distance = sqrt((x2 - x1) + (y2 - y1))
  [p1 p2]
  (Math/sqrt (Math/abs (+ (square (- (first p2) (first p1))) (square (- (second p2) (second p1)))))))

(defn calculate-polygon-perimeter
  "Finds the perimeter of a polygon given the co-ordinates of the polygons in a seq"
  [coll]
  (+
   (get-distance-between-two-points (last coll) (first coll))
   (loop [i 0 acc 0]
     (if (= i (dec (count coll)))
       acc
       (recur (inc i) (+ acc (get-distance-between-two-points (nth coll i) (nth coll (inc i)))))))))

(print (calculate-polygon-perimeter points))
