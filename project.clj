(defproject nilbank "0.1.0-SNAPSHOT"
  :description "nilbank"
  :url "https://github.com/0x0th30/nilbank"

  :exclude [log4j]
  :dependencies [[org.clojure/clojure "1.11.1"]]

  :profiles {:uberjar {:aot :all}

             :unit {:test-paths ^:replace ["test/integration/"]}

             :integration {:test-paths ^:replace ["test/unit/"]}

             :dev {:source-paths   ["dev"]
                   :resource-paths ["test/resources"]
                   :plugins        [[com.github.clojure-lsp/lein-clojure-lsp "1.4.9"]]
                   :dependencies   [[org.clojure/tools.namespace "1.4.4"]]
                   :repl-options   {:init-ns user}}}

  :min-lein-version "2.10.0"

  :aliases {"diagnostics"  ["clojure-lsp" "diagnostics"]
            "format"       ["clojure-lsp" "format" "--dry"]
            "format-fix"   ["clojure-lsp" "format"]
            "clean-ns"     ["clojure-lsp" "clean-ns" "--dry"]
            "clean-ns-fix" ["clojure-lsp" "clean-ns"]
            "lint"         ["do" ["diagnostics"] ["format"] ["clean-ns"]]
            "lint-fix"     ["do" ["clean-ns-fix"] ["format-fix"]]
            "unit"         ["with-profile" "+unit" "test"]
            "integration"  ["with-profile" "+integration" "test"]}

  :main ^:skip-aot nilbank.core

  :test-paths ["test/unit" "test/integration"])
