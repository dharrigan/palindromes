(ns palindrome.core (:require [clojure.string :as str]))

(defn palindrome?
  [palindrome]
  (let [y (str/lower-case (str/join (re-seq #"[A-Za-z]" palindrome)))]
    (= (str/reverse y) y)))

(defn -main
  [& args]
  (palindrome? (first args)))
