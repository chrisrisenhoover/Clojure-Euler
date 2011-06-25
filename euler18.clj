(ns clojure-euler.euler18)

(def my-triangle
     [[75]
      [95 64]
      [17 47 82]
      [18 35 87 10]
      [20 4 82 47 65]
      [19 1 23 75 3 34]
      [88 2 77 73 7 63 67]
      [99 65 4 28 6 16 70 92]
      [41 41 26 56 83 40 80 70 33]
      [41 48 72 33 47 32 37 16 94 29]
      [53 71 44 65 25 43 91 52 97 51 14]
      [70 11 33 28 77 73 17 78 39 68 17 57]
      [91 71 52 38 17 14 91 43 58 50 27 29 48]
      [63 66 04 68 89 53 67 30 73 16 69 87 40 31]
      [4 62 98 27 23 9 70 98 73 93 38 53 60 4 23]])

(def small-triangle
     [[3]
      [10 7]
      [12 14 13]
      [20 19 23 19]])
			       

(defn adjacent-sum
  [firstrow secondrow]
  (map max
       (map + (vec (cons 0 firstrow)) secondrow)
       (map + (vec (concat firstrow [0])) secondrow)))

(defn triangle-path-sum
  "takes a trianle x, cacluates maximum sums of adjacent paths, returns last row"
  [xtriangle]
  (loop [rowcount 1 sumrow (xtriangle 0)]
    (if (= rowcount (count xtriangle))
      sumrow
      (recur (inc rowcount)
	     (adjacent-sum sumrow (xtriangle rowcount))))))

(defn euler18
  []
  (time (apply max (triangle-path-sum my-triangle))))

;;"Elapsed time: 3.796907 msecs"
;;1074


