(ns clojure-euler.ten
  (:require [clojure.contrib.lazy-seqs :as lseq]))

(defn euler10
     [x]
     "trivial use of the primes function in lazy-seqs. Add up primes less than x."
     (reduce +
	     (take-while (partial > x) lseq/primes)))

;;(time (euler10 2000000))
;;"Elapsed time: 275.641214 msecs"
;;142913828922
