;; declate a namespace
(ns learn-clojure.core
  (:gen-class))

;; program entry point
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, teapot!"))

(defn error-message
  ;; arguments
  [severity]

  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))
