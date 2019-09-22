(ns {{namespace}}
  (:require [reagent.core :as r]
            [applied-science.js-interop :as j]))

(def initial-state {:now (js/Date.now)})
(defonce appstate! (r/atom initial-state))
(def now! (r/cursor appstate! [:now]))

(def root-element (j/get-in js/window [:root]))

(defn app []
  (let [now @now!]
    [:section.main
     [:h1 "hello!"]
     [:p "click below to update " [:span now]]
     [:button {:on-click (fn []
                           (prn ::resetting-now)
                           (reset! now! (rand-int 1000)))}
      "Click me"]]))

(defn init []
  (js/console.log "Init")
  (r/render [app] root-element))


(defn ^:dev/after-load start []
  (js/console.log "start")
  (init))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
