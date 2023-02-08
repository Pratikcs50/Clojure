;   "Don't get lost when creating a map"
  (println (= {:a 1 :b 2} (hash-map :a 1 :b 2))) 

;   "A value must be supplied for each key"
  (println (= {:a 1} (hash-map :a 1)))

;   "The size is the number of entries"
  (println (= 2 (count {:a 1 :b 2})))

;   "You can look up the value for a given key"
  (println (= 2 (get {:a 1 :b 2} :b))) ; value for key :b is printed

;   "Maps can be used as functions to do lookups"
  (println (= 1 ({:a 1 :b 2} :a))) ; a way to search in maps

;   "And so can keywords"
  (println (= 1 (:a {:a 1 :b 2})))

;   "But map keys need not be keywords"
  (println (= "Sochi" ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014)))

;   "You may not be able to find an entry for a key"
  (println (= nil (get {:a 1 :b 2} :c)))

;   "But you can provide your own default"
  (println (= :key-not-found (get {:a 1 :b 2} :c :key-not-found))) ; displays the default message

;   "You can find out if a key is present"
  (println (= true (contains? {:a nil :b nil} :b)))
  
;   "Or if it is missing"
  (println (= false (contains? {:a nil :b nil} :c)))

;   "Maps are immutable, but you can create a new and improved version"
  (println (= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February"))) ; adds new kew-value

;   "You can also create a new version with an entry removed"
  (println (= {1 "January"} (dissoc {1 "January" 2 "February"} 2))) ; subtracts key-val

;   "Create a new map by merging"
  (println (= {:a 1 :b 2 :c 3} (merge {:a 1 :b 2} {:c 3})))

;   "Specify how to handle entries with same keys when merging"
  (println (= {:a 1 :b 2 :c 3} (merge-with + {:a 1 :b 1} {:b 1 :c 3}))) ; it will add :b's value to 1+1

;   "Often you will need to get the keys, but the order is undependable"
  (println (= (list 2010 2014 2018)
     (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))) ; returns list of sorted values wrt keys

;   "You can get the values in a similar way"
  (println (= (list "PyeongChang" "Sochi" "Vancouver")
     (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"})))) ; returns list of sorted values wrt vals

;   "You can even iterate over the map entries as a seq"
  (println (= {:a 2 :b 3}
     (into {}    ; {} retruns all col
           (map
            (fn [[k v]] [k (inc v)]) ; incrementing value by 1
            {:a 1 :b 2}))))