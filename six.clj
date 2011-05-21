(ns devlib.clojure.euler.six)

(defn pwr
  "calculates and number to an exponent"
  [exp num]
  (if (zero? exp)
    1
    (* num (pwr (dec exp) num))))

(defn square-of-sum
  [the-seq]
  (pwr 2
   (reduce + the-seq)))

(defn sum-of-square
  [the-seq]
  (reduce + (map (partial pwr 2) the-seq)))

(do
  (- (square-of-sum (range 1 101))
     (sum-of-square (range 1 101))))
;; 25164150