; reduce - получение нового значения из последовательности

; signature
; fn(acc, val), initial value, collection

(reduce + [1 2 3]) ; 6
(reduce #(+ %1 %2) [1 2 3]) ; 6
(reduce #(+ %1 %2) 1 [1 2 3]) ; 7

(reduce conj [1 2 3] [4 5 6]) ; (1 2 3 4 5 6)
(reduce #(cons %2 %1) [1 2 3] [4 5 6]) ; (6 5 4 3 2 1)


; combine data structures
(reduce into [] [[1 2] '(3 4) #{5 6}]) ; [1 2 3 4 5 6]

; vector -> set
(reduce conj #{} [:a :a :b :c]) ; #{:c :b :a}


; transform a map’s values
; reduce воспримит map-аргумент как пос-ть векторов ([:max 10] [:min 11])
; assoc создает новый map на основании старого и переданных key-val аргументов
; (assoc {:a 1} :b 2 :a 10) => {:a 10, :b 2}
(defn increment-map-values [map-to-update]
  (reduce (fn [new-map [key val]]
    (assoc new-map key (inc val)))
    {}
    map-to-update))

(println (increment-map-values {:a 10 :b 11})) ; {:a 11, :b 12}


; другой пример использования
(def updated-nums (reduce
  ; acc - аккумулятор - формирует результат на каждом шаге редюса
  (fn [acc el]
    (conj acc (el * 2)))
   []
   my-seq))


; TODO! реализовать с помощью reduce другие методы для работы с колл-ми:
; map, filter и some
