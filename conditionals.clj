(defn explain-exercise-velocity [exercise-term]
  (case exercise-term
        :bicycling        "pretty fast"
        :jogging          "not super fast"
        :walking          "not fast at all"
        "is that even exercise?"))

; "You will face many decisions"
  (println (= :a (if (false? (= 4 5))      ; 4 not equal 5 hence first term after bracket is output/return value
                   :a                      ; if instead 4 5 would be there then :b would have been output
                   :b)))

;   "Some of them leave you no alternative"
  (println (= [] (if (> 4 3)               ; bydefault [] is output if true else nil is returned
          [])))

;   "And in such a situation you may have nothing"
  (println (= nil (if (nil? 0)             ; if true => [:a :b :c] output
                    [:a :b :c])))

;   "In others your alternative may be interesting"
  (println (= :glory (if (not (empty? ()))
                       :doom
                       :glory)))

;   "You may have a multitude of possible paths"
  (println (let [x 5]
             (= :your-road (cond (= x 1) :road-not-taken
                                 (= x 2) :another-road-not-taken    ; cond is a series of tests and expressions.
                                 :else :your-road))))               ; here the let expression is not satified hence else is returned

;   "Or your fate may be sealed"
  (println (= 'doom (if-not (zero? 1)
                      'doom
                      'more-doom)))

;   "In case of emergency, go fast"
  (println (= "pretty fast"
              (explain-exercise-velocity :bicycling)))

;   "But admit it when you don't know what to do"
  (println (= "is that even exercise?"
              (explain-exercise-velocity :watching-tv)))