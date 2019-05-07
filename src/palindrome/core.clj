(ns palindrome.core
  (:require [clojure.string :as str]))

(defn palindrome?
  [x]
  (let [y (str/lower-case (str/join (re-seq #"[A-Za-z]" x)))]
    (= (str/reverse y) y)))
