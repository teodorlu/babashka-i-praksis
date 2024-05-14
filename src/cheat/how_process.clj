(ns cheat.how-process
  (:require
   [babashka.process :as process]
   [clojure.string :as str]))

(clojure.repl/doc process/shell)

;; in a terminal
;;
;;     $ rlwrap bb
;;     user> (babashka.process/shell "nvim")

(str/split-lines (:out (process/shell {:out :string} "ls")))
