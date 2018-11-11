(ns learn-clojure.core
  (:gen-class))

(defn -main
  [& args]
  nil)


(defn fib
   ([] (fib 1 1))
   ([a b] (cons a (lazy-seq (fib b (+ a b))))))

(println (take 10 (fib)))
