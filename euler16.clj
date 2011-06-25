(ns clojure-euler.euler16
  (:use clojure.contrib.math))

(defn euler16
  "add up the digits of an expt 2 1000"
  []
  (time ( reduce +
		 (map
		  (comp #(Integer/parseInt %) str)
		  (seq (str (expt 2 1000)))))))
"Elapsed time: 4.513447 msecs"
1366