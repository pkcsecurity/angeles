(ns angeles.cljc.routes
  (:require [schema.core :as s]))

(def create-user-request-schema
  {:name s/Str})

(def create-user-response-schema
  {:id s/Int
   :name s/Str
   :claims-foo [s/Str]})

(def routes
  ["/"
   {"" {:get :angeles.clj.routes.index/index}
    "user/" {:post :angeles.clj.routes.user/create-user}
    true :angeles.clj.routes.impl/not-found}])

(def schemas
  {:angeles.clj.routes.user/create-user [create-user-request-schema
                                         create-user-response-schema]})
