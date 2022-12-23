;; PART 1

(def score-map
  {"A X" 4 ; rock rock
   "A Y" 8 ; rock paper
   "A Z" 3 ; rock scissors

   "B X" 1 ; paper rock
   "B Y" 5 ; paper paper
   "B Z" 9 ; paper scissors

   "C X" 7 ; scissors rock
   "C Y" 2 ; scissors paper
   "C Z" 6 ; scissors scissors
   })


(with-open [rdr (clojure.java.io/reader "input.txt")]
  (->> (line-seq rdr)
       (map score-map)
       (reduce +)
       ))

;; PART 2

(def score-map-2
  {"A X" 3 ; rock scissor
   "A Y" 4 ; rock rock
   "A Z" 8 ; rock paper

   "B X" 1 ; paper rock
   "B Y" 5 ; paper paper
   "B Z" 9 ; paper scissors

   "C X" 2 ; scissors rock
   "C Y" 6 ; scissors paper
   "C Z" 7 ; scissors scissors
   })

(with-open [rdr (clojure.java.io/reader "input.txt")]
  (->> (line-seq rdr)
       (map score-map-2)
       (reduce +)
       ))
