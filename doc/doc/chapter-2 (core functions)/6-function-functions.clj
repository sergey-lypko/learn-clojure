; -- -- apply -- --
; существуют функции, которые ожидают в качестве аргументов rest - то есть
; просто набор аргументов
(max 1 2 3) ; 3

; но что если возникнет необходимость применить такой метод к пос-ти
(max [1 2 3]) ; [1 2 3]

; это можно сделать с помощью apply
(apply max [1 2 3]) ; 3

; реализация метода into через apply
(defn my-into
  [target additions]
  (apply conj target additions))
; (my-into [0] [1 2 3]) => [0 1 2 3]


; -- -- partial -- --
; partial удобно использовать в ситуациях, при повторяющиихся
; вызовах функций и аргументов
(def add10 (partial + 10))
(def add30 (add10 20)) ; 30

(defn my-partial
  [partial-fn & first-args]
  (fn [& last-args]
    (apply partial-fn (into first-args last-args))))

(def add-10 (my-partial + 1 2))
(def fin (add-10 3 4))
(println fin) ; 10
