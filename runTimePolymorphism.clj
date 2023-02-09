(defn hello
  ([] "Hello World!")
  ([a] (str "Hello, you silly " a "."))
  ([a & more] (str "Hello to this group: "
                   (apply str
                          (interpose ", " (cons a more)))   ; Returns a lazy seq of the elements of coll separated by sep
                   "!")))

(defn eat [a food] (str (:name a) " eats " food "."))       ; function declared to eat conflict 

(defmulti diet (fn [x] (:eater x)))                         ; defmulti and defmethod is wrapped as multimethod means many funciton in one function
(defmethod diet :herbivore [a] (eat a "veggies"))           ; used to achieve run time polymorphism
(defmethod diet :carnivore [a] (eat a "animals"))           
(defmethod diet :default [a] "I don't know what Rich Hickey eats.")


;   "Some functions can be used in different ways - with no arguments"
(println (= "Hello World!" (hello)))

;   "With one argument"
(println (= "Hello, you silly world." (hello "world")))

;   "Or with many arguments"
(println (= "Hello to this group: Peter, Paul, Mary!"
            (hello "Peter" "Paul" "Mary")))

;   "Multimethods allow more complex dispatching"
(println (= "Bambi eats veggies."
            (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore})))

;   "Animals have different names"
(println (= "Thumper eats veggies."
            (diet {:species "rabbit" :name "Thumper" :age 1 :eater :herbivore})))

;   "Different methods are used depending on the dispatch function result"
(println (= "Simba eats animals."
            (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore})))

;   "You may use a default method when no others match"
(println (= "I don't know what Rich Hickey eats."
            (diet {:name "Rich Hickey"})))