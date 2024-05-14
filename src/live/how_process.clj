(ns live.how-process
  (:require
   [babashka.process :as process]
   [clojure.string :as str]))

(str/split-lines (:out (process/shell {:out :string} "ls")))
