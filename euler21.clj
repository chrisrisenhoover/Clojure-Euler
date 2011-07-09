(ns clojure-euler.euler21)

(defn in? 
  "true if seq contains elm"
  [seq elm]  
  (some #(= elm %) seq))

(defn proper-divisors
  "take a number and find its proper divisors"
  [n]
  (filter #(zero? (rem n %)) (range 1 n)))

(defn map-sum-of-proper-divisors
  "returns a map of all the numbers up to n, and their sum of proper divisors"
  [n]
  (map #(vector % (reduce + (proper-divisors %)))
       (range 1 (inc n))))

(defn frequency-of-sum
  "takes a map of proper divisors, adds them up , takes a frequency, dumps singles. Goal is that if a pair has the same sum, then it could be an amicable pair"
  [themap]
  (map #(% 0)
       (filter #(< 1 (% 1)) (frequencies (map #(+ (% 0) (% 1)) themap)))))

(defn possible-amicable-pairs
  "takes a frequency-of-sum and a map-sum-of-prover-divisors and pulls out possible winners"
  [mpsd fos]
  (filter #(in? fos (+ (% 0) (% 1))) mpsd))

(defn reverse-element-in-sequence
  [theseq]
  (filter #(in? theseq [(% 1) (% 0)]) theseq))

(defn remove-equals
  [theseq]
  (remove #(= (% 0) (% 1)) theseq))

(defn amicable-pairs
  [n]
  (let [themap (map-sum-of-proper-divisors n)
	thefreqmap (frequency-of-sum themap)]
    ((comp remove-equals reverse-element-in-sequence possible-amicable-pairs)
     themap thefreqmap)))

(defn euler21
  []
  (time (/ (apply +
	    (map #(+ (% 0) (% 1)) (amicable-pairs 10000)))
	   2)))

;;"Elapsed time: 99980.492802 msecs"
;;31626
;;==============

(defn sum-proper-divisors
  [n]
  (reduce + (proper-divisors n)))

(defn amicable-number?
  [n]
  (let [n1 (sum-proper-divisors n)
	n2 (sum-proper-divisors n1)]
    (and (= n n2)
	 (not (= n n1)))))
	

(defn euler21-improved
  "find the sum of proper divisors in a range from 1 to n-1"
  [n]
  (apply + (filter amicable-number? (range 1 n))))

;;"Elapsed time: 58853.855089 msecs"
;;31626
  

 
  




		
    