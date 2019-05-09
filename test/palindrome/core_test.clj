(ns palindrome.core-test
  (:require [clojure.test :as t]
            [clojure.test.check.generators :as gen]
            [clojure.string :as str]
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

(def gen-strings
  (gen/sample (gen/fmap #(apply str %) (gen/vector gen/char-alpha 10)) 100))

(defn gen-palindromes
  []
  (for [string gen-strings]
    (str/reverse (str string (str/reverse string)))))

(t/deftest generated-palindromes
  (doseq [palindrome (gen-palindromes)]
    (t/is #(= true %) (p/palindrome? palindrome))))

(t/deftest english-palindromes
  (doseq [palindrome palindromes]
    (t/is #(= true %) (p/palindrome? palindrome))))
