(defn square [a]
  (* a a))
(println (square 70))


(defn bg [v]
  (+ (apply max v) 1))
(println (bg [1 2 3 4 5]))

(defn bg [v]
  ((+(comp apply max (v)) 1)))
(println (bg [1 2 3 4 5]))