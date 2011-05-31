(ns clojure-euler.euler1)

(defn divisable-by?
  "takes a number, returns a function that will test for division"
  [test]
  ( fn[x] (zero? (mod x test))))

(def divisable-by-3? (divisable-by? 3))
(def divisable-by-5? (divisable-by? 5))

(defn add-naturals-based-on-rule
  [max fn-rule]
  (reduce + (filter fn-rule (range 1 (inc max)))))

(defn euler1
  []
  (do
  (add-naturals-based-on-rule
   999
   (fn[x] (or (divisable-by-5? x) (divisable-by-3? x))))))
;;"Elapsed time: 3.816997 msecs"
;;233168

