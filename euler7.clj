(ns clojure-euler.euler7
  (:require [clojure.contrib.lazy-seqs :as lseqs]))

;;seeking the 10001st prime, primes maps 0th -> 2, 1th -> 3, so take one  away
(defn euler7
  (time
   (nth lseqs/primes (- 10001 1))))


;;(time (nth lseqs/primes (- 10001 1)))
;;"Elapsed time: 6.311184 msecs"
;;104743



      