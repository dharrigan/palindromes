(ns palindrome.core 
  (:require [clojure.string :as str])
  (:gen-class))

(defn palindrome?
  [palindrome]
  (let [y (str/lower-case (str/join (re-seq #"[A-Za-z]" palindrome)))]
    (= (str/reverse y) y)))

(defn -main
  [& args]
  (println (palindrome? (first args))))
