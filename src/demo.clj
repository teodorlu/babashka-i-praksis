(ns demo
  (:require
   [babashka.cli :as cli]
   [babashka.fs :as fs]
   [babashka.process :as process]
   [clojure.string :as str]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; BABASHKA/FS

(comment
  ;; fs operates on a File type
  (type (fs/file "deps.edn"))
  ;; => java.io.File

  ;; most functions work with both java.io.File and strings.

  (count (fs/read-all-bytes "deps.edn"))
  ;; => 160

  (count (fs/read-all-bytes (fs/file "deps.edn")))
  ;; => 160

  ;; list all clojure files in the current directory:
  (fs/glob "." "**.clj")

  ;; fs/glob lists in an arbitrary order. A sorted order is often more convenient.
  (->>
   (fs/glob "." "**.clj")
   (sort-by str))

  ;; fs/which lets you know if a binary exists

  (fs/which "gcc")
  ;; => #object[sun.nio.fs.UnixPath 0x429990d8 "/usr/bin/gcc"]

  (fs/which "github-atom")
  ;; => nil

  ;; fs/create-dirs can create multiple directories from one call.
  ;;
  ;; Nice to ensure that your application's config directory exists.

  (fs/create-dirs "my/weird/new-folder-hierarchy")
  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; BABASHKA/PROCESS

(comment
  ;; mostly you just need two functions:
  process/shell :and process/process

  ;; But mostly, you just need process/shell.

  (str/split-lines (:out (process/shell {:out :string} "ls")))
  ;; => ["README.md"
  ;;     "bb.edn"
  ;;     "deps.edn"
  ;;     "how.sh"
  ;;     "mob.sh"
  ;;     "qa.sh"
  ;;     "slides"
  ;;     "src"
  ;;     "welcome.sh"
  ;;     "what.sh"]

  )


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; BABASHKA/CLI

(comment
  ;; mostly you just need two functions:
  cli/dispatch :and cli/parse-opts

  (cli/parse-opts ["--verbose" "--depth" "3"])
  ;; => {:verbose true, :depth 3}

  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; BABASHKA/CLI and BABASHKA/PROCESS together

(defn cmd-start [opts]
  (prn [:started opts]))

(defn cmd-nvim [_opts]

  )

(def dispatch-table
  [{:cmds ["start"] :fn cmd-start}
   {:cmds ["stop"] :fn #(vector :stop %)}])
