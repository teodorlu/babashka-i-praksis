(ns demo
  (:require
    [babashka.fs :as fs]))

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
