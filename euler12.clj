(ns clojure-euler.euler12)

(def naturals (iterate inc 1))

(def triangles (map
		(fn[x] (reduce + (range 1 (inc x))))
		naturals))

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
(defn nth-triangle
  [x]
  (/ (* x (+ x 1)) 2))


(defn count-factors
  [a-factor-map]
  (reduce *
	(map inc (vals a-factor-map))))


(defn euler12
  "find the triangle number with at least num-divisors"
  [num-divisors]
  (loop [tnd num-divisors triangle-index 3 tnum 3]
    (if (<= tnd (count-factors (factor-map tnum)))
      tnum
      (recur tnd (inc triangle-index) (nth-triangle (inc triangle-index))))))

;;"Elapsed time: 12028.898868 msecs"
;;7657650;;"Elapsed time: 12028.898868 msecs"
;;76576500
   
    
  
    





 

  
  
  