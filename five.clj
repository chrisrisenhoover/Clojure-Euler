(ns clojure-euler.five)

(defn pwr
  "calculates and number to an exponent"
  [num exp]
  (if (zero? exp)
    1
    (* num (pwr num (dec exp)))))

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

(defn lcm-collection
  "find the Least Common Multiple of a sequence of numbers"
  [the-seq]
  (let [lcm-as-map (apply (partial merge-with max)
			  (map factor-map the-seq))]
    (reduce * (map pwr (keys lcm-as-map) (vals lcm-as-map)))))
;;(time (lcm-collection (range 2 21)))
;;"Elapsed time: 0.673415 msecs"
;;232792560
    

