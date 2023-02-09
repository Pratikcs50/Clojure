
; complement returns the opposite value in form of fn


(defn square [x] (* x x)) ; function to print square


; "One may know what they seek by knowing what they do not seek"
(println (= [true false true] (let [not-a-symbol? (complement symbol?)] ;complement returns a function that is opp to symbol?
                                (map not-a-symbol? [:a 'b "c"]))))

; "Praise and 'complement' may help you separate the wheat from the chaff"
(println (= [:wheat "wheat" 'wheat]
            (let [not-nil? (complement nil?)]
              (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil]))))

; "Partial functions allow procrastination"
(println (= 20 (let [multiply-by-5 (partial * 5)]                        ; here value 4 is being called after execution of above line due to partial fn
                  (multiply-by-5 4)))) 

; "Don't forget: first things first"
(println (= [:a :b :y :z]
             (let [ab-adder (partial concat [:a :b])]
               (ab-adder [:y :z])))) 

; "Functions can join forces as one 'composed' function"
(println (= 25 (let [inc-and-square (comp square inc)]                   ; inc is applied first then comp which returns square(4+1)
                  (inc-and-square 4)))) 

; "Have a go on a double dec-er"
(println (= 8 (let [double-dec (comp dec dec)]
                (double-dec 10))))

; "Be careful about the order in which you mix your functions"
(println (= 99 (let [square-and-dec (comp dec square)]
                  (square-and-dec 10)))) 


