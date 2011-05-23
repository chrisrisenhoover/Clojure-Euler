(ns clojure-euler.nine
  (:require [clojure.contrib.math :as m]))


(defn pythag-triplet?
  "takes three numbers and test to see if they are a pythagorean triplet"
  [a b c]
  (let [sqr #(* % %)]
    (and
     (< a b c)
     (= (+ (sqr a) (sqr b)) (sqr c)))))

(defn natural-triplets-whose-sum-is
  [sum]
  (for [x (range 1 sum) y (range 1 sum)
	:let [thediff (- sum x y)]
	:when (pos? thediff)]
    (list x y thediff)))

(defn pythag-triplets-whose-sum-is
  [sum]
  (for [x (range 1 sum) y (range 1 sum)
	:let [thediff (- sum x y)]
	:when (and (pos? thediff)
		   (pythag-triplet? x y thediff))
	]
    (list x y thediff)))

;;(time (reduce * (first (pythag-triplets-whose-sum-is 1000))))
;;"Elapsed time: 425.673834 msecs"
;;31875000

(defn euler9
  []
  (reduce * (first
	     (pythag-triplets-whose-sum-is 1000))))
	
   