;  "Lists can be expressed by function or a quoted form"
  (println (= '(1 2 3 4 5) (list 1 2 3 4 5))) ; both syntax represrnt list

;   "They are Clojure seqs (sequences), so they allow access to the first"
  (println (= 1 (first '(1 2 3 4 5)))) ; first returns 1 element of column

;   "As well as the rest"
  (println (= '(2 3 4 5) (rest '(1 2 3 4 5)))) ; return all element except first

;   "Count your blessings"
  (println (= 3 (count '(dracula dooku chocula)))) ; counts of list items

;   "Before they are gone"
  (println (= 0 (count '())))

;   "The rest, when nothing is left, is empty"
  (println (= () (rest '(100))))
  
;   "Construction by adding an element to the front is easy"
  (println (= '(:a :b :c :d :e) (cons :a '(:b :c :d :e)))) ; cons append item to first of the list items

;   "Conjoining an element to a list isn't hard either"
  (println (= '(:e :a :b :c :d) (conj '(:a :b :c :d) :e))) ; conjoining to a list is done at the beginning

;   "You can use a list like a stack to get the first element"
  (println (= :a (peek '(:a :b :c :d :e)))) ; same as first

;   "Or the others"
  (println (= '(:b :c :d :e) (pop '(:a :b :c :d :e)))) ;  returns a new list without the first item

;   "But watch out if you try to pop nothing"
  (println (= "No dice!" (try
          (pop '())
          (catch IllegalStateException e
            "No dice!"))))

;   "The rest of nothing isn't so strict"
  (println (= () (try
          (rest '())
          (catch IllegalStateException e
            "No dice!"))))