(ns day1.core
  (:gen-class))

(defn get-integers []
  (map #(Integer/parseInt %)
       (clojure.string/split (slurp (clojure.java.io/resource "input"))
                             #"\n")))

(defn get-sum [list-of-numbers]
  (reduce + 0 list-of-numbers))

(defn add-till-double [frequencies last-frequency changes]
  (let [next-change (first changes)
        new-frequency (+ next-change last-frequency)]
;;    (println frequencies)
    (cond (.contains ^clojure.lang.PersistentHashSet frequencies new-frequency) new-frequency
;          ( = (inc index) (count changes)) (recur [(conj frequencies new-frequency) (rest changes 0])
          :else (recur (conj frequencies new-frequency) new-frequency (rest changes)))))
    
(defn -main
  ""
  [& args]
 (print (add-till-double #{} 0 (cycle (get-integers)))))
