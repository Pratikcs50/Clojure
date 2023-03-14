(def atomic-clock (atom 0))
; "Atoms are like refs"
(println (= 0 @atomic-clock))  

;   "You can change at the swap meet"
 (println (= 1 (do
          (swap! atomic-clock inc)
          @atomic-clock))) 

;   "Keep taxes out of this: swapping requires no transaction"
  (println (= 5 (do
         (swap! atomic-clock + 4)
         @atomic-clock)))

;   "Any number of arguments might happen during a swap"
  (println (= 20 (do
          (swap! atomic-clock + 1 2 3 4 5)
          @atomic-clock)))

;   "Atomic atoms are atomic"
  (println (= 20 (do
          (compare-and-set! atomic-clock 100 :fin)
          @atomic-clock)))

;   "When your expectations are aligned with reality, things proceed that way"
  (println (= :fin (do
            (compare-and-set! atomic-clock 20 :fin)
            @atomic-clock)))

