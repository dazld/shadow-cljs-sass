(ns leiningen.new.shadow-cljs-sass
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files project-name multi-segment sanitize-ns year date]]
            [leiningen.core.main :as main]))

(def render (renderer "shadow-cljs-sass"))

(defn shadow-cljs-sass
  "FIXME: write documentation"
  [name]
  (let [main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :year (year)
              :date (date)

              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' shadow-cljs-sass project.")
    (->files data
             ["deps.edn" (render "deps.edn" data)]
             [".gitignore" (render "gitignore" data)]
             ["Makefile" (render "Makefile" data)]
             ["package.json" (render "package.json" data)]
             ["README.md" (render "README.md" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]
             ["src/{{nested-dirs}}.cljs" (render "core.cljs" data)]
             ["sass/main.scss" (render "main.scss" data)]
             ["sass/lib/_breakpoints.scss" (render "_breakpoints.scss" data)]
             ["public/index.html" (render "index.html" data)])))
