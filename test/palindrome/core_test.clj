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
  (gen/sample (gen/fmap #(apply str %) (gen/vector gen/char-alpha 10))))

(defn gen-palindromes
  []
  (for [x gen-strings]
    (str/reverse (str x (str/reverse x)))))

(t/deftest all-palindromes
  (t/testing "palindromes"
    (for [x (conj palindromes (gen-palindromes))]
      (t/is (every? #(= true %) (p/palindrome? x))))))
