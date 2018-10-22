(ns angeles.clj.routes.index
  (:require [angeles.clj.views.index :as idx]
            [angeles.clj.routes.impl :as impl]))

(def index (constantly {:status 200
                        :headers {"Content-Type" "text/html"}
                        :body idx/index}))
