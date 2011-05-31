
(ns clojure-euler.euler4)


(defn palindrome-number-test
  "take a number, convert it to a sequence test to see if it is a palindrome"
  [num]
  (let [num-sequence (re-seq #"[0-9]" (str num))
	reverse-num-sequence (reverse num-sequence)]
    (= num-sequence reverse-num-sequence)))

(defn palindromes-in-a-range
  "take a range, find the carteisan product, look for the largest palindrome"
  [r1 r2]
  (for [x (range r1 (inc r2)) y (range r1 (inc r2))
	:let [test-val (* x y)]
	:when (palindrome-number-test test-val)]
    test-val))

(defn largest-palindrome-in-range
  [r1 r2]
  (reduce max (palindromes-in-a-range r1 r2)))

(defn euler4
  []
  (time (largest-palindrome-in-range 100 999)))

;;"Elapsed time: 5943.124408 msecs"
;;906609
    
    





    


     
		
	 
	  
  