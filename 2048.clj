;board design 
(def layout {  :boundary      "*****"
               :cell      "%4s|"
               :cellEdge "|"
               :boundaryEdge "*"})

(def directions {:w :up
                 :s :down
                 :a :left
                 :d :right})

(def size {:y 4 :x 4})



;cells design 
(defn cells->str [line]                    
  (str (:cellEdge layout)
       (clojure.string/join (map (partial format (:cell layout)) line))
       "\n"))

; boundary-edge + and boundary design
(defn boundaries->str [width]
  (str (:boundaryEdge layout)
       (clojure.string/join (repeat width (:boundary layout)))
       "\n"))

;merging bounaries and cells
(defn field->str [field]
  (let [height (count field)
        width (count (first field))]
    (str (clojure.string/join (interleave (repeat height (boundaries->str width))
                               (map cells->str field)))
         (boundaries->str width))))



;input of the keys

(defn inputKeys []
  (let [input (read)
        try ((keyword input) directions)]
    (if try try (recur))))

(defn getColumns [field]
  (vec (for [x (range (count (first field)))]
         (vec (for [y (range (count field))]
                (get-in field [y x]))))))

(defn reverseRow [field]
  (mapv #(vec (reverse %)) field))

(defn padding [coll n sym]
  (vec (concat coll (repeat n sym))))

(defn emptyField [field]
  (remove
    nil?
    (for [y (range (count field))
          x (range (count (nth field y)))]
      (when (= (get-in field [y x]) \space) [y x]))))

(defn add [field]
  (let [empties (vec (emptyField field))]
    (assoc-in field
              (rand-nth empties)
              (rand-nth (conj (vec (repeat 9 2)) 4))))) 


; win and lose logic
(defn win [field]
  (= 2048
     (transduce
       (filter number?)
       (completing max)
       0
       (flatten field))))

(defn lose [field]
  (empty? (filter (partial = \space) (flatten field))))

(defn startGame [y x]
  (->> (vec (repeat y (vec (repeat x \space))))
       (add)
       (add)))

; game implementation
(defn lines [back? direction field]
  (case direction
    :left field
    :right (reverseRow field)
    :down (if back?
            (getColumns (reverseRow field))
            (reverseRow (getColumns field)))
    :up (getColumns field)))

(defn shift [line]
  (let [len (count line)
        line (vec (filter number? line))
        max-idx (dec (count line))]
    (loop [new [] idx 0]
      (if (> idx max-idx)
          (padding new (- len (count new)) \space)
          (if (= (nth line idx) (get line (inc idx)))
              (recur (conj new (* 2 (nth line idx))) (+ 2 idx))
              (recur (conj new (nth line idx)) (inc idx)))))))

(defn shiftingField [direction field]
  (->> (lines false direction field)
       (mapv shift)
       (lines true direction)))

(defn overflow [field]
  (let [direction (inputKeys)]
    (->> (shiftingField direction field)
         (add))))

(defn play-2048 []
  (loop [field (startGame (:y size) (:x size))]
    (println (field->str field))
    (cond (win field) (println "You win")
          (lose field) (println "You lose")
          :default (recur (overflow field)))))

(play-2048)
