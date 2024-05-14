(ns live.how-cli
  (:require [babashka.cli :as cli]))

(babashka.cli/parse-opts ["--verbose" "--depth" "3"])
;; => {:verbose true, :depth 3}

(def dispatch-table
  [{:cmds ["start"] :fn #(vector :start %)}
   {:cmds ["stop"] :fn #(vector :stop %)}])

(babashka.cli/dispatch dispatch-table ["start" "--verbose" "--depth" "3"])
;; => [:stop {:dispatch ["start"], :opts {:verbose true, :depth 3}, :args nil}]

(babashka.cli/dispatch dispatch-table ["start"])
;; => {:dispatch ["start"], :opts {}, :args nil}


(clojure.repl/doc cli/dispatch)
(clojure.repl/doc cli/parse-opts)
