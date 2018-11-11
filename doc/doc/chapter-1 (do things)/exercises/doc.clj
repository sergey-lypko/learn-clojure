; --- --- --- symmetrize-body-parts --- --- ---
; used:  let, loop & recur, into, replace
(def hobbit-body-parts
      [{:name "left-eye"}
      {:name "left-ear"}
      {:name "left-forearm"}
      {:name "left-hand"}
      {:name "left-foot"}])

(defn matching-part
  [part]
  ; ^ - для того, чтобы матчить с начала строки
  {:name (clojure.string/replace (:name part) #"^left-" "right-")})

; функция реализует одну из общих концепций в функциональном программировании*:
; дана последовательность, функция при этом разделяет
; эту последовательность на  голову и хвост
; обрабатывает голову, добавляет ее к какому-то результату (например [])
; после чего использует рекурсию, чтобы продолжить
; обработку хвоста, пока тот не закончится
(defn symmetrize-body-parts [body-parts]
  ; remaining-body-parts: body-parts, final-body-parts: [] (результат)
  (loop [remaining-body-parts body-parts final-body-parts []]
    ; если хвост пуст - обработана вся последовательность
    (if (empty? remaining-body-parts)
      ; и можно вернуть результат
      final-body-parts
      ; иначе - разделяем пос-ть на голову (part) и хвост (remaining)
      (let [[part & remaining] remaining-body-parts]
        ; т.е здесь берем первый элемент (part),
        ; создаем его копию, заменяя left- на right-
        ; отправляем это в final-body-parts, а остальное
        ; отправляем дальше в loop, пока remaining не закончится
        (recur remaining
          ; set ~ #{{:name left-arm} {:name right-arm}}
          (into final-body-parts (set [part (matching-part part)])))))))

(def symmetrize (symmetrize-body-parts hobbit-body-parts))



; то же самое с помощью reduce
; задача reduce - это обработка колекции и в конеченом итоге получения результата
(defn reduce-symmetrize
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
      (into final-body-parts (set [part (matching-part part)])))
    []
    asym-body-parts))


; умножение списка чисел на 2 по такому же принципу* (концепции ФП)
(defn handle-sequence [seq]
  (loop [sequence seq
         result []]
    (if (empty? sequence)
    result
    (let [[first & rest] sequence]
      (recur rest (conj result (* first 2)))))))

(def mult (handle-sequence [1 2 3 4 5 6 7])) ; 2 4 6 8 10 12 14


; реализация функции (multiply-parts), которая берет список частей тела
; и добавляет n кол-во к каждому, создавая плоский вектор
(defn multiply-part [part multiply-index]
  (let [part-name (get part :name)]
    (loop [iteration 2 parts [part]]
      (if (> iteration multiply-index)
        parts
        (recur (inc iteration)
          (conj parts {:name (str part-name "-" iteration)}))))))

(defn multiply-parts
  [body-parts]
  (reduce (fn [final-parts part]
            (into final-parts (set(multiply-part part 3))))
          []
          body-parts))
