(ns day1.core
  (:gen-class))

(defn get-integers []
  (map #(Integer/parseInt %)
       (clojure.string/split (slurp (clojure.java.io/resource "input"))
                             #"\n")))

(defn get-sum [list-of-numbers]
  (reduce + 0 list-of-numbers))

(defn add-till-double [[frequencies changes index]]
  (let [next-change (nth changes index)
        new-frequency (+ next-change (last frequencies))]
;;    (println frequencies)
    (cond (.contains frequencies new-frequency) new-frequency
          ( = (inc index) (count changes)) (recur [(conj frequencies new-frequency) changes 0])
          :else (recur [(conj frequencies new-frequency) changes (inc index)]))))
    
(defn -main
  ""
  [& args]
 (print (add-till-double [[0] (get-integers) 0])) )
