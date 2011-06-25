(ns clojure-euler.euler17)

(def number2name {0 "",
		  1 "one",
		  2 "two",
		  3 "three",
		  4 "four",
		  5 "five",
		  6 "six",
		  7 "seven",
		  8 "eight",
		  9 "nine",
		  10 "ten",
		  11 "eleven",
		  12 "twelve",
		  13 "thirteen",
		  14 "fourteen",
		  15 "fifteen",
		  16 "sixteen",
		  17 "seventeen",
		  18 "eighteen",
		  19 "nineteen",
		  20 "twenty",
		  30 "thirty",
		  40 "forty",
		  50 "fifty",
		  60 "sixty",
		  70 "seventy",
		  80 "eighty",
		  90 "ninety",
		  100 "hundred",
		  1000 "thousand"})
(defn convert-number-to-name
  "take a number and convert it to its string counterpart"
  ( [n] (convert-number-to-name n nil))
  ([number numname]
  (if (<= number 10)
    (str numname (number2name number))
    (if (>= number 1000)
      (convert-number-to-name (mod number 1000) (str numname (number2name (quot number 1000)) "thousand"))
      (if (>= number 100)
	(convert-number-to-name (mod number 100) (str numname (number2name (quot number 100)) "hundred" (if (> (mod number 100) 0) "and")))
	(if (>= number 20)
	  (convert-number-to-name (mod number 10) (str numname (number2name (* 10 (quot number 10)))))
	  (if (>= number 10)
	    (str numname (number2name number)))))))))
									    

(defn euler17
  []
  (time (reduce + (map (comp count convert-number-to-name) (range 1 1001)))))

  
  
   
     
 