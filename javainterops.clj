;  "You may have done more with Java than you know" 
(println (= String (class "warfare"))) ; hint: try typing (javadoc "warfare") in the REPL

;   "The dot signifies easy and direct Java interoperation"
(println (= "SELECT * FROM" (.toUpperCase "select * from")))

;   "But instance method calls are very different from normal functions"
(println (= ["SELECT" "FROM" "WHERE"] (map #(.toUpperCase %) ["select" "from" "where"])))

;   "Constructing might be harder than breaking"
(println (= 10 (let [latch (java.util.concurrent.CountDownLatch. 10)]
                 (.getCount latch))))

;   "Static methods are slashing prices!"
(println (== 1024 (Math/pow 2 10)))