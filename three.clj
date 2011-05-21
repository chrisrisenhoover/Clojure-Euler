
(ns clojure-euler.three)

(defn biggest-factor
  "takes a number, starts at lowest prime and starts to factor"
  [num]
  (loop [n num test-factor 2]
    (if (= n test-factor)
      n
      (if (zero? (rem n test-factor))
	(recur (quot n test-factor) test-factor)
	(recur n (inc test-factor))))))

;;(time (biggest-factor 600851475143))
;;"Elapsed time: 65.708399 msecs"
;;6857

;; do the same thing, but return a factor map. Useful for later problems.

(defn factor-map
  "takes a number, starts at lowest prime and starts to factor. Return Map."
  [num]
  (loop [n num test-factor 2 factor-map {}]
    (if (= n test-factor)
      (merge-with + factor-map {test-factor 1})
      (if (zero? (rem n test-factor))
	(recur (quot n test-factor)
	       test-factor
	       (merge-with + factor-map {test-factor 1}))
	       (recur n
		      (inc test-factor)
		      factor-map)))))

;;(time (factor-map 600851475143))
;;"Elapsed time: 10.696705 msecs"
;;{6857 1, 1471 1, 839 1, 71 1}




     
 