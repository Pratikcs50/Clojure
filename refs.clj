; ref 


(def the-world (ref "hello"))
(def bizarro-world (ref {}))


; "In the beginning, there was a word"
  (println (= @the-world (deref the-world)))

; "You can get the word more succinctly, but it's the same"
  (println (= (deref the-world) @the-world))

; "You can be the change you wish to see in the world."
  (println (= "better" (do
          (dosync (ref-set the-world "better"))
          @the-world)))

; "Alter where you need not replace"
  (println (= "better!!!" (let [exclamator (fn [x] (str x "!"))]
          (dosync
           (alter the-world exclamator)
           (alter the-world exclamator)
           (alter the-world exclamator))
          @the-world)))

; "Don't forget to do your work in a transaction!"
  (println (= 0 (do
         (dosync (ref-set the-world 0))
           @the-world)))

; "Functions passed to alter may depend on the data in the ref"
  (println (= 20 (do
          (dosync (alter the-world #(+ 20 %))))))

; "Two worlds are better than one"
  (println (= ["Real Jerry" "Bizarro Jerry"]
       (do
         (dosync
          (ref-set the-world {})
          (alter the-world assoc :jerry "Real Jerry")
          (alter bizarro-world assoc :jerry "Bizarro Jerry")
          (map :jerry [@the-world @bizarro-world])))))