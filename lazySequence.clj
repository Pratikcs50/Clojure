; "There are many ways to generate a sequence" 
(println (= '(1 2 3 4) (range 1 5)))                           ; generate range from 1 to 4 (inclusive)

;  "The range starts at the beginning by default"
(println (= '(0 1 2 3 4) (range 5)))

;   "Only take what you need when the sequence is large"
(println (= [0 1 2 3 4 5 6 7 8 9]                              ; take takes first n cloumns
            (take 10 (range 100))))

;   "Or limit results by dropping what you don't need"
(println (= [95 96 97 98 99]
            (drop 95 (range 100))))                            ; drops n columns
;   "Iteration provides an infinite lazy sequence"
(println (= [1 2 4 8 16 32 64 128]
            (take 8 (iterate (fn [x] (* x 2)) 1))))            ; iterate-> returns a lazy sequence till overflow.

;   "Repetition is key"
(println (= [:a :a :a :a :a :a :a :a :a :a]
            (repeat 10 :a)))                                   ; repeats n columns

;   "Iteration can be used for repetition"
(println (= (repeat 100 "hello")
            (take 100 (iterate identity "hello"))))        