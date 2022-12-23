;; PART 1
(with-open [rdr (clojure.java.io/reader "input.txt")]
  (let [max-calories (atom 0)
        elf-index (atom 0)
        current-cal (atom 0)
        current-index (atom 1)]
    (doseq [line (line-seq rdr)]
      (if-not (empty? line)
        (swap! current-cal (fn [cal] (+ cal (read-string line))))
        (do (when (> @current-cal @max-calories)
              (reset! max-calories @current-cal)
              (reset! elf-index @current-index))
            (reset! current-cal 0)
            (swap! current-index inc))))
    @max-calories)
  )

;; PART 2
(defn assign-top-three [top1 top2 top3 new-val]
  (if (< new-val top3)
    [top1 top2 top3]
    (if (> new-val top1)
      [new-val top1 top2]
      (if (> new-val top2)
        [top1 new-val top2]
        (if (> new-val top3)
          [top1 top2 new-val])))))

(with-open [rdr (clojure.java.io/reader "input.txt")]
  (let [top1 (atom 0)
        top2 (atom 0)
        top3 (atom 0)
        current-cal (atom 0)]
    (doseq [line (line-seq rdr)]
      (if-not (empty? line)
        (swap! current-cal (fn [cal] (+ cal (read-string line))))
        (let [[new-top1 new-top2 new-top3] (assign-top-three @top1 @top2 @top3 @current-cal)]
          (reset! top1 new-top1)
          (reset! top2 new-top2)
          (reset! top3 new-top3)
          (reset! current-cal 0))))
    (+ @top1 @top2 @top3))
  )
