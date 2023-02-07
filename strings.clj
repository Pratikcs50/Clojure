
;   "A string is nothing more than text surrounded by double quotes"
  (println (= "hello" "hello")) ; only double quotes are referred as strings

;   "But double quotes are just magic on top of something deeper"
  (println (= "world" (str 'world))) ; type str 'world => string

;   "You can do more than create strings, you can put them together"
  (println (= "Cool right?" (str "Cool" " right?")))

;   "You can even get certain characters"
  (println (= \C (get "Characters" 0))) ; the first character is C, if it's 1 then h

;   "Or even count the characters"
  (println (= 11 (count "Hello World"))) ; total 11 character including space

;   "But strings and characters are not the same"
  (println (= false (= \c "c")))

;   "What if you only wanted to get part of a string?"
  (println (= "World" (subs "Hello World" 6 11))) ; World starts from 6+1 to 11

;   "How about joining together elements in a list?"
  (println (= "123" (clojure.string/join '(1 2 3))))

;   "What if you wanted to separate them out?"
  (println (= "1, 2, 3" (clojure.string/join ", " '(1 2 3))))

;   "Maybe you want to separate out all your lines"
  (println (= ["1" "2" "3"] (clojure.string/split-lines "1\n2\n3")))

; ;   "You may want to make sure your words are backwards"
;   (println )(= __ (string/reverse "hello"))

; ;   "Maybe you want to find the index of the first occurrence of a substring"
;   (println )(= 0 (string/index-of "hello world" __))

; ;   "Or maybe the last index of the same substring"
;   (println )(= __ (string/last-index-of "hello world, hello" "hello"))

; ;   "But when something doesn't exist, nothing is found"
;   (println )(= __ (string/index-of "hello world" "bob"))

; ;   "Sometimes you don't want whitespace cluttering the front and back"
;   (println )(= __ (string/trim "  \nhello world \t \n"))

; ;   "You can check if something is a char"
;   (println )(= __ (char? \c))

; ;   "But it may not be"
;   (println )(= __ (char? "a"))

; ;   "But chars aren't strings"
;   (println )(= __ (string? \b))

; ;   "Strings are strings"
;   (println )(= true (string? __))

; ;   "Some strings may be blank"
;   (println )(= __ (string/blank? ""))

; ;   "Even if at first glance they aren't"
;   (println )(= __ (string/blank? " \n \t  "))

; ;   "However, most strings aren't blank"
;   (println )(= __ (string/blank? "hello?\nare you out there?"))