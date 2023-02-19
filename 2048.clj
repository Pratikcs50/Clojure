
(def layout {  :boundary      "----+"
               :cell      "%4s|"
               :cellEdge "|"
               :boundaryEdge "+"})

(def directions {:w :up
                 :s :down
                 :a :left
                 :d :right})

(def field-size {:y 4 :x 4})

;board design 

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
