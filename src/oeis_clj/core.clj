(ns oeis-clj.core)

;; parses oeis seqs ex: "1, 2, 2, 3, 2, 4, 2" into clojure seqs
(defn oeis-parser 
  "parses a oeis string to a coll"
  [seq-string] 
  (map #(- % 48) (map int (remove #(or (= % \,) (= % \space)) (vec seq-string)))))

;; parses oeis.org results html into clojure seq
(defn parse-oeis-page 
  "given a seq id string ~ 'A000005', return a seq from oeis.org"
  [anumber] 
  (oeis-parser (first (re-seq #"\d+,.*\d+,.*\d+,.*\d+,.*\d+" 
    (slurp (reduce str (concat "http://oeis.org/" (str anumber))))))))

;; search helper for http posting
(defn search-formatter 
  "interposes '%2C+' to a coll to make a proper search string"
  [coll] (reduce str (interpose "%2C+" coll)))

;; searches oeis for string/seq names, returns coll if found
 (defn oeis-search-string 
   "experimental (isn't it always?) - searches oeis for s (like 'fibonacci') 
   and returns first answer as a coll."
   [s] (parse-oeis-page 
         (str "search?q=" (search-formatter s) "&language=english&go=Search")))
