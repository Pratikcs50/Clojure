; "To split a collection you can use the partition function"
  (print (= '((0 1) (2 3)) (partition 2 (range 4))))

  "But watch out if there are not enough elements to form n sequences"
  (print (= '((:a :b :c)) (partition 3 [:a :b :c :d :e])))

  "You can use partition-all to include any leftovers too"
  (print (= '((0 1 2)(3 4))(partition-all 3 (range 5))))

  "If you need to, you can start each sequence with an offset"
  (print (= '((0 1 2) (5 6 7) (10 11 12)) (partition 3 5 (range 13))))

  "Consider padding the last sequence with some default values"
  (print (= '((0 1 2) (3 4 5) (6 :hello)) (partition 3 3 [:hello] (range 7))))

  "But notice that they will only pad up to the given sequence length"
  (print (= '((0 1 2) (3 4 5) (6 :these :are)) (partition 3 3 [:these :are "my" "words"] (range 7))))