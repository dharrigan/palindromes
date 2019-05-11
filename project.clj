(defproject palindrome "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :plugins [[io.taylorwood/lein-native-image "0.3.0"]]
  :native-image {:name "palindromes"
                 :opts ["--report-unsupported-elements-at-runtime"]}
  :main ^:skip-aot palindrome.core
  :repl-options {:init-ns palindrome.core}
  :profiles {:dev {:global-vars {*warn-on-reflection* true
                                 *assert* true}}
             :uberjar {:aot 
                       :all
                       :native-image {:jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}})
