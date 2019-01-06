; (reduce f collection) (reduce f opt-initial-val collection)

; итеративный проход по последовательности
; функция f получает на вход 1й и 2й э-ты последовательности
; на след. итерации функция f получает на вход результат ^ (первым аргументом) и 3й э-т последовательности
; если opt-initial-val было передано, функция f начнет действие над ним и 1м э-м последовательности


(defn sum-numbers [coll]
  (reduce (fn [acc-result next-item]
    (+ first second))
      coll))

; то же самое ^ через анонимную функцию
(defn sum-numbers-shortand [coll]
  (reduce #(+ %1 %2) coll))


(defn combine [keys numbers]
  (reduce (fn [map number]
    (assoc map (nth keys (- number 1)) number)) {} numbers))

(println (combine [:a :b :c] [1 2 3])) ; {:a 1, :b 2, :c 3}


(reduce conj [1 2 3] [4 5 6])
; (1 2 3 4 5 6)

(reduce conj #{} [:a :b :c])
; #{:a :b :c}
