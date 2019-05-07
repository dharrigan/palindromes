(ns palindrome.core-test
  (:require [clojure.test :as t]
            [palindrome.core :as p]))

(def palindromes [
                  "Able was I ere I saw Elba"
                  "A man, a plan, a canal – Panama"
                  "Madam, I'm Adam"
                  "Never odd or even"
                  "Doc, note: I dissent. A fast never prevents a fatness. I diet on cod"
                  "redivider"
                  "deified"
                  "civic"
                  "radar"
                  "level"
                  "rotor"
                  "kayak"
                  "reviver"
                  "racecar"
                  "redder"
                  "madam"
                  "refer"
                  ])

(t/deftest test-palindromes
  (for [x palindromes]
    (t/is (= true (p/palindrome? x)))))
