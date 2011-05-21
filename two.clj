;; redo with inclusion of evens
(ns clojure-euler.two)

(defn fibonnaci-numbers
  "calculates the fibonnaci series with a lazy seq"
  [n1 n2]
  (lazy-seq
   (cons (+ n1 n2) (fibonnaci-numbers n2 (+ n1 n2)))))

(defn fibonnaci-transform-f1-filter-f2
  [num f1 f2]
  (reduce f1 (filter f2 (take-while (partial > num) (fibonnaci-numbers 0 1)))))

(time (fibonnaci-transform-f1-filter-f2 4000000 + even?))
;"Elapsed time: 0.482271 msecs"
;;4613732


