(ns clojure-euler.euler14.clj)

(defn colatz-seq
  "takes a number and produces the colatz-seq recursively"
  [starting-number]
  (loop [n starting-number cs (conj [] starting-number)]
    (if (= 1 n)
      cs
      (if (even? n)
	(recur (quot n 2) (conj cs (quot n 2)))
	(recur (+ (* n 3) 1) (conj cs (+ (* n 3) 1)))))))

(defn max-colatz-below-number
  "test the values to find longest colatz"
  [maxnum]
  (loop [testnum maxnum winning-number 1 winning-length 1]
    (let [test-colatz-length (count (colatz-seq testnum))
	  current-winner (if (> test-colatz-length winning-length)
			   testnum
			   winning-number)
	  winning-length (max winning-length test-colatz-length)]
	  
    (if (= 1 testnum)
      winning-number
      (recur (dec testnum)
	     current-winner
	     winning-length)))))

;;"Elapsed time: 145123.969397 msecs"
;;837799
	     

;;different soltuion, based on counting steps
(defn colatz-steps
  [n]
  (if (= n 1)
    1
    (if (even? n)
      (+ 1 (colatz-steps (/ n 2)))
      (+ 1 (colatz-steps (+ (* 3 n) 1))))))

(defn max-colatz-2
  [maxnum]
  (loop [n 1 steps 1 winner 1]
    (if (= n maxnum)
      winner
      (let [current-steps (colatz-steps n)]
	(recur (inc n)
	       (if (> current-steps steps)
		 current-steps
		 steps)
	       (if (> current-steps steps)
		 n
		 winner))))))

;;(time (max-colatz-2 999999))
;;"Elapsed time: 84320.1629 msecs"
;;837799

(def mcolatz-steps (memoize colatz-steps))
(defn max-colatz-3
  [maxnum]
  (loop [n 1 steps 1 winner 1]
    (if (= n maxnum)
      winner
      (let [current-steps (mcolatz-steps n)]
	(recur (inc n)
	       (if (> current-steps steps)
		 current-steps
		 steps)
	       (if (> current-steps steps)
		 n
		 winner))))))
;;"Elapsed time: 96388.89509 msecs"
;;837799

(defn euler14
  ([] (euler14 999999))
  ([n]
     (time (max-colatz-2 n))))
