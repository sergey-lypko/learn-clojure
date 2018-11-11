(map inc [1 2 3]) ; (2 3 4)

; map может принимать несколько коллекций
; эл-ты из первой коллекции будут переданы как первый аргумент в str,
; эл-ты второй - как второй аргумент соответственно
; главное, чтобы функция (в данном случае str) могла принять столько же ар-в,
; сколько коллекций передается в map

(map str ["a" "b" "c"] ["A" "B" "C"]) ; ("aA" "bB" "cC")
(map + [1 2 3] [3 2 1]) ; (4 4 4)


(defn combine [first second third]
  {:fs first :sc second :th third})

(def fs ["1f" "2f"])
(def sc ["1s" "2s"])
(def th ["1t" "2t"])

(def res (map combine fs sc th))
; ({:fs 1f, :sc 1s, :th 1t} {:fs 2f, :sc 2s, :th 2t})


; ч-з анонимную функцию
(map #(str "Hello " %) ["A" "B" "C"]))
; ("Hello A" "Hello B" "Hello C")


; получение значений из коллекций через :keyword
; так как keyword может использоваться как функция,
; map может применить его к пос-ти
(def data
  [{:val "Val 1" :other "Some other"}
   {:val "Val 2" :other "Some other 2"}
   {:val "Val 3" :other "Some other 3"}])

(def res (map :val data))
; (Val 1 Val 2 Val 3)
