(print "We shall contemplate truth by testing reality, via equality")
(newline)
(println (= true true))

;To understand reality, we must compare our expectations against reality
(println (= 2 (+ 1 1)))  ; 2 equals to 1+1 => + 1 1 

;You can test equality of many things
(println (= (+ 3 4) 7 (+ 2 5)))  ; equality of three operands

;Some things may appear different, but be the same
(println (= true (= 2 2/1 4/2))) ; 4/2=2=2/1

;You cannot generally float to heavens of integers
(println (= false (= 2 2.0))) ; integer is not equal to float

;But a looser equality is also possible
(println (= true (== 2.0 2))) ; here == => compares loosely

;Something is not equal to nothing
(println (= true (not (= 1 nil)))) ; 1 not equal nil

;Strings, and keywords, and symbols: oh my!
(println (= false (= "hello" :hello 'hello))) ; string != keyword != symbol

;Make a keyword with your keyboard
(println (= :hello (keyword "hello"))) ; declaration of keyword :xyz or keyword "xyz"

;Symbolism is all around us
(println (= 'hello (symbol "hello")))  ; declaration of symbol '(xyz) or keyword "xyz"

;What could be equivalent to nothing?
(println (=  nil)) ; only nil equals nothing

;When things cannot be equal, they must be different 
(not= :fill-in-the-blank 123) ; not= function 
