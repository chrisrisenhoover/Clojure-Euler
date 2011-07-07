(ns clojure-euler.euler20)

(defn factorial
  [n]
  (apply * (range 2 (inc n))))

(defn euler20
  []
  (reduce +(map #(Integer. (str %)) (str (factorial 100)))))


