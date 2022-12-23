
(with-open [rdr (clojure.java.io/reader "input.txt")]
  (let [occurence-map (atom {})]
    (->> (seq "alexx")
         (reduce (fn [map letter]
                   (assoc map letter (inc (get map letter 0))))
                 occurence-map)
         )))

(with-open [rdr (clojure.java.io/reader "input.txt")]
  (doseq [line (line-seq rdr)]
    (let [occurence-map {}
          map1 (atom {})
          map2 (atom {})
          [half1 half2] (split-at (/ (count line) 2) line)]
      (->> half1
           (reduce (fn [set letter] (swap! set conj letter)) map1)
           ))))

(with-open [rdr (clojure.java.io/reader "input.txt")]
  (doseq [line  (line-seq rdr)]
    (print line)))

(let [occurence-map {}]
  (->> "alexxl"
       seq
       (reduce (fn [map letter] (assoc map letter (inc (get map letter 0))))
               occurence-map)
       ))


(def test-s "alexxl")
(let [[half1 half2] (split-at (/ (count test-s) 2) test-s)
      set1 (atom #{})
      set2 (atom #{})]
  (reduce (fn [[set1 set2] [half1 half2]]
            (swap! set1 conj half1)
            (swap! set2 conj half2))
          [set1 set2] [half1 half2]))
