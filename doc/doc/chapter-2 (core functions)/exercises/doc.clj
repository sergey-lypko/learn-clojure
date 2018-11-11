(def suspects-database {
   0 {:drinks-blood? false, :has-pulse? true  :name "Otto"}
   1 {:drinks-blood? false, :has-pulse? true  :name "McFishwich"}
   2 {:drinks-blood? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:drinks-blood? true,  :has-pulse? false :name "Drakula"}
   4 {:drinks-blood? false, :has-pulse? false :name "It"}
   5 {:drinks-blood? false, :has-pulse? true :name "God of War"}})

(defn get-vampire-details
  [person-index]
  (get suspects-database person-index))

(defn vampire?
  [record]
  (and (:drinks-blood? record) (not (:has-pulse record))))

(def expected-range (map get-vampire-details (range 4)))

(def vimpire (first (filter vampire? expected-range)))
; {:drinks-blood? true, :has-pulse? false, :name Damon Salvatore}
