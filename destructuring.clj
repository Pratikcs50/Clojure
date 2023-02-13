; destructuring allows to extract data values and bind them to symbol 
; data structures such as vectors etc.


(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

; "Destructuring is an arbiter: it breaks up arguments"
(println (= ":bar:foo" ((fn [[a b]] (str b a))
       [:foo :bar])))

; "Whether in function definitions"
(println (= (str "An Oxford comma list of apples, "
          "oranges, "
          "and pears.")
     ((fn [[a b c]] (str "An Oxford comma list of " a ", " b ", and " c "."))
      ["apples" "oranges" "pears"])))

; "Or in let expressions"
(println (= "Rich Hickey aka The Clojurer aka Go Time aka Lambda Guru"
     (let [[first-name last-name & aliases]
           (list "Rich" "Hickey" "The Clojurer" "Go Time" "Lambda Guru")]
       (apply str
            (interpose " aka "
                       (cons (str first-name " " last-name) aliases))))))

; "You can regain the full argument if you like arguing"
(println (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}}
   (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
     {:original-parts full-name :named-parts{:first first-name :last last-name}})))

; "Break up maps by keys"
(println (= "123 Test Lane, Testerville, TX"
   (let [{street-address :street-address, city :city, state :state} test-address]
     (str street-address ", " city ", " state))))

; "Or more succinctly"
(println (= "123 Test Lane, Testerville, TX"
   (let [{:keys [street-address city state]} test-address]
     (str street-address ", " city ", " state))))

"All together now!"
(println (= "Test Testerson, 123 Test Lane, Testerville, TX"
     ((fn [[first last] {:keys [street-address city state]}]
        (str first " " last ", " street-address ", " city ", " state)) ["Test" "Testerson"] test-address)))