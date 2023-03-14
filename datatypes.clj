(defrecord Nobel [prize])
(deftype Pulitzer [prize])

(defprotocol Award
  (present [this recipient]))

(defrecord Oscar [category]
  Award
  (present [this recipient]
    (print (str "Congratulations on your "
                (:category this) " Oscar, "
                recipient
                "!"))))

(deftype Razzie [category]
  Award
  (present [this recipient]
    (print (str "You're really the "
                category ", "
                recipient
                "... sorry."))))


; "Holding records is meaningful only when the record is worthy of you"
  (println (= "peace" (.prize (Nobel. "peace"))))

;   "Types are quite similar"
  (println (= "literature" (.prize (Pulitzer. "literature"))))

;   "Records may be treated like maps"
  (println (= "physics" (:prize (Nobel. "physics"))))

;   "While types may not"
  (println (= nil (:prize (Pulitzer. "poetry"))))

;   "Further study reveals why"
  (println (= [true false]
     (map map? [(Nobel. "chemistry")
                (Pulitzer. "music")])))

;   "Either sort of datatype can define methods in a protocol"
  (println (= "Congratulations on your Best Picture Oscar, Evil Alien Conquerors!" 
     (with-out-str (present (Oscar. "Best Picture") "Evil Alien Conquerors"))))

;   "Surely we can implement our own by now"
  (println (= "You're really the Worst Picture, Final Destination 5... sorry."
     (with-out-str (present (Razzie. "Worst Picture") "Final Destination 5"))))