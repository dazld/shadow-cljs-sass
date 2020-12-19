(ns {{namespace}}
  (:require [reagent.core :as r]
            [reagent.dom :as dom]
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

(defn ^:dev/after-load start []
  (js/console.log "start")
  (dom/render [app] root-element))

(defn init []
  (js/console.log "Init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
