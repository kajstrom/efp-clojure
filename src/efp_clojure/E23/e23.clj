(ns efp-clojure.E23.e23
  (:require [efp-clojure.utils.prompt :refer :all]))

(def is-car-silent (make-bool-prompt "Is the car silent when you turn the key?"))
(def are-bat-terminals-corroded (make-bool-prompt "Are the battery terminals corroded?"))
(def does-car-click (make-bool-prompt "Does the car make a clicking noise?"))
(def clean-terminals (make-output "Clean terminals and try starting again"))
(def replace-cables (make-output "Replace cables and try again"))
(def replace-battery (make-output "Replace the battery"))
(def does-car-crank (make-bool-prompt "Does the car crank up but fail to start?"))
(def check-spark-plug (make-output "Check spark plug connections."))
(def does-engine-start (make-bool-prompt "Does the engine start and then die?"))
(def noop #(identity nil))
(def does-car-have-finjection (make-bool-prompt "Does your car have fuel injection?"))
(def get-service (make-output "Get it in for service."))
(def check-choke (make-output "Check to ensure the choke is opening and closing"))

(def troubleshoot-tree {:fn is-car-silent
                        true {:fn are-bat-terminals-corroded
                              true clean-terminals
                              false replace-cables}
                        false {:fn does-car-click
                               true replace-battery
                               false { :fn does-car-crank
                                       true check-spark-plug
                                       false {:fn does-engine-start
                                              true {:fn does-car-have-finjection
                                                    true get-service
                                                    false check-choke}
                                              false noop}
                                       }}})

(defn process-tree
  [tree]
  (if (map? tree)
    (let [next-tree (get tree ((:fn tree)))]
      (process-tree next-tree))
    (tree)))

(defn run
  []
  (process-tree troubleshoot-tree))