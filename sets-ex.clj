(ns sets-ex
  "sets-ex"
  (:require
    [clojure.set :as set]))


; "You can create a set by converting another collection"
  (println (= #{3} (set '(3)))) ; set created from list

; "Counting them is like counting other collections"
  (println (= 3 (count #{1 2 3})))
  
; "Remember that a set is a *mathematical* set"
  (println (= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5)))) ; repetitions are not included

; "You can ask Clojure for the union of two sets"
  (println (= #{1 2 3 4 5} (set/union set(1 2 3 4) set(2 3 5))))
  
; "And also the intersection"
  (println (= #{2 3} (set/intersection #{1 2 3 4} #{2 3 5}))) 

; "But don't forget about the difference"
  (println (= #{1 4} (set/difference #{1 2 3 4 5} #{2 3 5})))