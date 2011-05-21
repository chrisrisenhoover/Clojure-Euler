(ns clojure-euler.seven
  (:require [clojure.contrib.lazy-seqs :as lseqs]))

;;seeking the 1001 prime, primes maps 0th -> 2, 1th -> 3, so take two away
(do
  (nth lseqs/primes 999))


      