(ns experiments.example1
  (:require [clojure.java.jdbc :as j]))

(def demo-settings
  {
   :classname   "org.h2.Driver"
   :subprotocol "h2:mem"
   :subname     "demo;DB_CLOSE_DELAY=-1"
   :user        "sa"
   :password    ""})

(defn try-h2 []
  (j/query demo-settings ["show databases"])

  (j/execute! demo-settings ["create table csvdata (id int primary key, name varchar(100), age int)"])
  (j/execute! demo-settings ["insert into csvdata values(1, 'hello', 20)"])
  (j/execute! demo-settings ["insert into csvdata values(2, 'world', 21)"])
  (j/query demo-settings ["select * from csvdata"])
  (j/query demo-settings ["select * from csvdata where name = 'hello'"])
  )

(try-h2)