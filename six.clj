(ns clojure-euler.six
  (:require [clojure.contrib.math :as math]))


(defn square-of-sum
  [the-seq]
  (math/expt (reduce + the-seq) 2))

(defn sum-of-square
  [the-seq]
  (reduce + (map #(math/expt % 2) the-seq)))

(do
  (- (square-of-sum (range 1 101))
     (sum-of-square (range 1 101))))
;; 25164150