;Higher order function is a function that take on or more funciton as arguments and returns a function as result
; defn vs fn defn is var that points to fn object.

; "The map function relates a sequence to another"
  (println (= [4 8 12] (map (fn [x] (* 4 x)) [1 2 3]))) ; here the vector is served as input and processed in sequential manner

;   "You may create that mapping"
  (println (= [1 4 9 16 25] (map (fn [x] (* x x)) [1 2 3 4 5])))

;   "Or use the names of existing functions"
  (println (= [false false true false false] (map nil? [:a :b nil :c :d]))) ; value is directly compared to each one in vector.

;   "A filter can be strong"
  (println (= () (filter (fn [x] false) '(:anything :goes :here)))) ; filter returns where it returns true but this statement is fallacy

;   "Or very weak"
  (println (= '(:anything :goes :here) (filter (fn [x] true) '(:anything :goes :here)))) ; aways true 

;   "Or somewhere in between"
  (println (= [10 20 30] (filter (fn [x] (if(< x 40) [10 20 30])) [10 20 30 40 50 60 70 80]))) ; fiter combined with if statement

;   "Maps and filters may be combined"
  (println (= [10 20 30] (map (fn [x] (* 10 x)) (filter (fn [x] (<= x 3)) [1 2 3 4 5 6 7 8])))) 

;   "Reducing can increase the result"
  (println (= 24 (reduce (fn [a b] (* a b)) [1 2 3 4])))

;   "You can start somewhere else"
  (println (= 2400 (reduce (fn [a b] (* a b)) 100 [1 2 3 4]))) ; reduce function is used to call initial element to first element of vector and so on

;   "Numbers are not the only things one can reduce"
  (println (= "longest" (reduce (fn [a b]
                         (if (< (count a) (count b)) b a))
                       ["which" "word" "is" "longest"])))