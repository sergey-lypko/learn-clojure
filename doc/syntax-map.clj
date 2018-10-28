; --- --- --- УСЛОВИЯ --- --- ---
; ------------------------------

; -- -- do -- --
; do позволяет оберунть блок кода в круглые скобки и
; выполнить все инструкции оттуда

(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  ; else
  (do (println "Failure!")
      "By Aquaman's trident!"))


; -- -- when -- --
; when - это комбинация if и do (но без else)
; используется, для того, чтобы выполнить несколько инструкций,
; если какое-то условие правдиво
; в противном случае - вернуть nil

(when true
  (println "Success!")
  "abra cadabra")



; --- --- --- ЛОГИЧЕСКИЕ ОПЕРАТОРЫ --- --- ---
; ------------------------------------------

; or - вернет либо первое правдивое либо последнее значение
; and - первое ложное значение, иначе - последнее правдивое

(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; => :large_I_mean_venti

(and :free_wifi :hot_coffee)
; => :hot_coffee



; --- --- --- ОПРЕДЕЛЕНИЯ --- --- ---
; ----------------------------------

; -- -- def -- --
; def СВЯЗЫВАЕТ (не путать с присваиванием) имя со значением

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protagonist-names
; => ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"]



; --- --- --- СТРУКТУРЫ ДАННЫХ --- --- ---
; ---------------------------------------

; -- -- maps -- --
; maps похожи на словари или хэши в других языках
; в Clojure сущестует 2 типа maps: hash maps и sorted maps

; литерал
{:first-name "Charlie"
 :last-name "McFishwich"}

; создание через функцию
(hash-map :a 1 :b 2)
; => {:a 1 :b 2}

; поиск через get
; ищем значение, ассоциирующиеся с ключем :b
(get {:a 0 :b 1} :b)
; => 1

(get {:a 0 :b {:c "ho hum"}} :b)
; => {:c "ho hum"}

; nil - если ничего не найдено
(get {:a 0 :b 1} :c)
; => nil
