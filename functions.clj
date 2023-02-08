(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

; "Calling a function is like giving it a hug with parentheses"
  (println (= 81 (square 9)))

; "Functions are usually defined before they are used"
  (println (= 20 (multiply-by-ten 2)))

; "But they can also be defined inline"
  (println (= 10 ((fn [n] (* 5 n)) 2))) ; important

; "Or using an even shorter syntax"
  (println (= 60 (#(* 15 %) 4))) ; % replaced by input 4

; "Even anonymous functions may take multiple arguments"
  (println (= 15 (#(+ %1 %2 %3) 4 5 6)))

; "Arguments can also be skipped"
  (println (= "AACC" (#(str "AA" %2) "bb" "CC")))

; "One function can beget another"
  (println (= 9 (((fn [] +)) 4 5)) ) ; this means 4+5
  
;  "Functions can also take other functions as input"
  (println (= 20 ((fn [f] (f 4 5)) *)))
           
  
;  "Higher-order functions take function arguments"
  (println (= 25 (#(% 5)
          (fn [n] (* n n))))
)

;  "But they are often better written using the names of functions"
  (println (= 25 (#(% 5) square)))