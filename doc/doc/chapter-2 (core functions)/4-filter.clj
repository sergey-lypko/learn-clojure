(defn only-numbers [val]
  (number? val))

(def nums-res (filter #(number? %) [1 2 "s" "ab" 3 4]))
; (1 2 3 4)


(def food-journal
  [{:month 1 :day 1 :human 5.3}
   {:month 2 :day 2 :human 5.0} ; <=
   {:month 3 :day 2 :human 4.0} ; <=
   {:month 4 :day 3 :human 3.7}])

(def res (filter #(= (:day %) 2) food-journal))
; ({:month 2, :day 2, :human 5.0} {:month 3, :day 2, :human 4.0})
