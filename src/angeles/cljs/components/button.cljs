(ns angeles.cljs.components.button
  (:require 
    [angeles.cljs.components :as c]
    [reagent.core :as r]))

(def css
  {::button {:default
             {:padding "0.75rem 1rem"
              :background-color (c/pkc-colors :teal)
              :font-size (c/text-sizes :h6)
              :border-width "2px"
              :border-color (c/pkc-colors :teal)
              :outline :none
              :color (c/pkc-colors :white)
              :cursor :pointer
              :transition "all 0.2s ease-in-out"}

             ::dangerous?
             {:background-color (c/pkc-colors :red)
              :border-color (c/pkc-colors :red)
              :color (c/pkc-colors :white)}

             ::dangerous-hovered?
             {:background-color :red
              :border-color :red
              :color (c/pkc-colors :white)}

             ::ghosted?
             {:background-color :transparent
              :border-color :transparent
              :color (c/pkc-colors :teal)}

             ::secondary?
             {:background-color :transparent
              :border "2px solid"
              :border-color (c/pkc-colors :teal)
              :color (c/pkc-colors :teal)}
              
             ::hovered?
             {:color (c/pkc-colors :white)
              :border-color (c/pkc-colors :success)
              :background-color (c/pkc-colors :success)}}})

(defn button [_ _]
  (let [hover-atom (r/atom false)]
    (fn [text {:keys [on-click
                      disabled?
                      ghosted?
                      dangerous?
                      secondary?]}]
      (let [hovered? @hover-atom]
        [:button {:on-mouse-enter (c/on hover-atom)
                  :on-mouse-leave (c/off hover-atom)
                  :on-click (fn [e]
                              (when-not disabled?
                                (on-click e)))
                  :style (c/css-options (css ::button)
                                        ::ghosted? ghosted?
                                        ::secondary? secondary?
                                        ::hovered? hovered?
                                        ::dangerous? dangerous?
                                        ::dangerous-hovered? (and dangerous?
                                                                  hovered?))}
         text]))))

(defn test-section []
  [c/section "Buttons"
   [:div
    [c/container "Primary Button"
     [button "Button Text"
      {:on-click #(js/alert "click")}]]
    [c/container "Secondary Button"
     [button "Button Text"
      {:secondary? true
       :on-click #(js/alert "click")}]]    
    [c/container "Ghost Button"
     [button "Button Text"
      {:ghosted? true
       :on-click #(js/alert "click")}]]
    [c/container "Dangerous Button"
     [button "Button Text"
      {:dangerous? true
       :on-click #(js/alert "click")}]]]])
