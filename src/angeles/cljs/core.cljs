(ns angeles.cljs.core
   (:require [accountant.core :as accountant]
             [bidi.bidi :as bidi]
             [angeles.cljc.routes :as routes]
             [angeles.cljs.components :as c]
             [angeles.cljs.components.button :as btn]
             [angeles.cljs.components.input :as in]
             [angeles.cljs.xhr :as xhr]
             [reagent.core :as r]))

(def session (atom {}))

(enable-console-print!)

(def css
  {::body {:display :flex
           :align-items :center
           :margin-top "3rem"
           :flex-direction :column}})

(defn body []
  [:div {:style (css ::body)}
   [:h2.measure "Ángeles"]
   [:p.measure
    "PKC has been around for a while. We've written a ton of UIs, but we've never
    written one in our own style. We have colors now. We have our own ideas. Let's 
    instantiate that. This is my twist on Salesforce Lightning Design and IBM Carbon.
    B2B doesn't necessarily mean crappy design."]
   [:p.measure
    "This is me rage coding, so caveat emptor. Maybe none of this code survives. Hopefully
    some of the weird ideas in here enrich our thinking on Clojurescript UI work. 
    Regardless, it was either program this UI or exert a ton of energy not drinking 
    a Vesper (the only true martini)."]
   [:p.measure
    "This is preferable!"]
   [in/test-section]
   [btn/test-section]])

(defn app []
  [:div#app
   [c/style]
   [:div#body
    [body]]])

(defn on-js-load []
  (r/render-component [app]
                      (. js/document (getElementById "reagent"))
                      (fn [_]
                        (xhr/fetch-roundtrip :angeles.clj.routes.user/create-user
                                             {:name "Bob Landon"}))))

(defn -main []
  (accountant/configure-navigation!
    {:nav-handler (fn [path]
                    (let [{page-kw :handler 
                           rps :route-params} (bidi/match-route 
                                                routes/routes 
                                                path)]
                      (swap! session 
                             assoc
                             :route
                             {:current-page page-kw
                              :route-params rps})))
     :path-exists? (fn [path]
                     (boolean (bidi/match-route routes/routes path)))})
  (accountant/dispatch-current!)
  (on-js-load))

(-main)
