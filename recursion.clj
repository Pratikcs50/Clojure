
;Recursion is top-down approach which involve function calling itself untill the base case is reached.


(defn is-even? [n]
  (if (= n 0)
    true
    (not (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      false
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  (if (empty? (rest coll))
    coll
    (cons (last coll)
          (recursive-reverse (butlast coll)))))

(defn factorial [x]
  (loop [n x
         f 1]
    (if (= 1 n)
      f
      (recur (dec n) (* f n)))))

; "Recursion ends with a base case"
  (println (= true (is-even? 0)))             

;  "And starts by moving toward that base case"
  (println (= false (is-even? 1)))

;   "Having too many stack frames requires explicit tail calls with recur"
  (println (= false (is-even-bigint? 100003N)))

;   "Reversing directions is easy when you have not gone far"
  (println (= '(1) (recursive-reverse [1])))

;   "Yet it becomes more difficult the more steps you take"
  (println (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5])))

;   "Simple things may appear simple."
  (println (= 1 (factorial 1)))

;   "They may require other simple steps."
  (println (= 2 (factorial 2)))

;   "Sometimes a slightly bigger step is necessary"
  (println (= 6 (factorial 3)))

;   "And eventually you must think harder"
  (println (= 24 (factorial 4)))

;   "You can even deal with very large numbers"
  (println (< 1000000000000000000000000N (factorial 1000N)))

;   "But what happens when the machine limits you?"
  (println (< 1000000000000000000000000N (factorial 100003N)))