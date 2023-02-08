;   "You can use vectors in clojure as array-like structures"
(println (= 1 (count [42]))) ; returns no. of ele in vector

;   "You can create a vector from a list"
(println (= [1] (vec '(1))))

;   "Or from some elements"
(println (= [nil nil] (vector nil nil))) ; nil is counted as element check -> (count  (vector nil nil)) = 2

;   "But you can populate it with any number of elements at once"
(println (= [1 2] (vec '(1 2))))

;   "Conjoining to a vector is different than to a list"
(println (= [111 222 333] (conj [111 222] 333))) ; unlike list it appends at last

;   "You can get the first element of a vector like so"
(println (= :peanut (first [:peanut :butter :and :jelly])))

;   "And the last in a similar fashion"
(println (= :jelly (last [:peanut :butter :and :jelly])))

;   "Or any index if you wish"
(println (= :jelly (nth [:peanut :butter :and :jelly] 3)))

;   "You can also slice a vector"
(println (= [:butter :and] (subvec [:peanut :butter :and :jelly] 1 3))) ; slicing of vector from index 1 to 3, 3 not included

;   "Equality with collections is in terms of values"
(println (= (list 1 2 3) (vector 1 2 3)))