(ns angeles.clj.routes.user
  (:require [angeles.clj.routes.impl :as impl]))

(impl/defroute create-user [{{:keys [name] :as x} :body}]
  (impl/ok
    {:id 1
     :name name
     :claims-foo ["a" "b" "c"]}))
