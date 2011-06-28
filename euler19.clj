(ns clojure-euler.euler19)

;;How many Sundays where on the first of the month

;;starting date is WEEKDAY MONTHDAY MONTH YEAR
;;define this as a DATEVEC

(def days-in-month
     {1 31, 2 28, 3 31, 4 30, 5 31, 6 30,
      7 31, 8 31, 9 30, 10 31, 11 30, 12 31})

(defn leap-year?
  "test if a year is a leap year"
  [year]
  (if (zero? (rem year 1000))
    (if (zero? (rem year 400))
      true
      false)
    (if (zero? (rem year 4))
      true
      false)))

(defn end-of-month?
  [datevector]
  (if (= 2 (datevector 2))
    (if (leap-year? (datevector 3))
      (if (= (inc (days-in-month (datevector 2))) (datevector 1))
	true
	false)
      (if ( = (days-in-month (datevector 2)) (datevector 1))
	true
	false))
    (if (= (datevector 1) (days-in-month (datevector 2)))
      true
      false)))

(defn end-of-week?
  [datevector]
  (if (= 7 (datevector 0))
    true
    false))

(defn end-of-year?
  [datevector]
  (if (and (= 12 (datevector 2)) (= 31 (datevector 1)))
    true
    false))

(defn sunday-first-month?
  [datevector]
  (if (and (= 7 (datevector 0)) (= 1 (datevector 1)))
    (do
      (print datevector)
      true)
    false))

(defn next-day
  [datevector]
  (let [next-weekday (if (end-of-week? datevector)
		       1
		       (inc (datevector 0)))
	next-monthday (if (end-of-month? datevector)
			1
			(inc (datevector 1)))
	next-month (if (end-of-month? datevector)
		     (if (end-of-year? datevector)
		       1
		       (inc (datevector 2)))
		     (datevector 2))
	next-year (if (end-of-year? datevector)
		    (inc (datevector 3))
		    (datevector 3))]
    (vector next-weekday next-monthday next-month next-year)))
		     			  
  
(defn euler19
  [start-date]
  (loop [the-date start-date count 0]
    (if (= 2001 (the-date 3))
      count
      (recur (next-day the-date)
	     (if (and (sunday-first-month? the-date) (<= 1901 (the-date 3)))
	       (inc count)
	       count)))))

;;(time (euler19 [1 1 1 1900]))
;;"Elapsed time: 221.860254 msecs"
;;171

    
 


      
      
  

