
(def textures {:wall      "----+"
               :cell      "%4s|"
               :cell-edge "|"
               :wall-edge "+"})

(def directions {:w :up
                 :s :down
                 :a :left
                 :d :right})

(def field-size {:y 4 :x 4})

;board design 

;cells design 
(defn cells->str [line]                    
  (str (:cell-edge textures)
       (clojure.string/join (map (partial format (:cell textures)) line))
       "\n"))

; wall-edge + and walls design
(defn walls->str [width]
  (str (:wall-edge textures)
       (clojure.string/join (repeat width (:wall textures)))
       "\n"))


(defn field->str [field]
  (let [height (count field)
        width (count (first field))]
    (str (clojure.string/join (interleave (repeat height (walls->str width))
                               (map cells->str field)))
         (walls->str width))))

