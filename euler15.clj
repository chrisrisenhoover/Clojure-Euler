(ns clojure-euler.euler15)

(defn factorial
  [num]
  (loop [x num fact 1]
    (if (zero? x)
      fact
      (recur (dec x) (* x fact)))))

(defn factorial2
  [num]
  (if (= num 1)
    1
    (* num (factorial2 (dec num)))))

(defn paths-through-board
  "calculates paths through a square board"
  [boardx boardy]
  (/ (factorial2 (+ boardx boardy))
     (* (factorial2 boardx) (factorial2 boardy))))

(defn euler15
  []
  (time (paths-through-board 20 20)))



"Elapsed time: 0.860149 msecs"
137846528820