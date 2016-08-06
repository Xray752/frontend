(ns frontend.components.pieces.text-input
  (:require [devcards.core :as dc :refer-macros [defcard]]
            [om.core :as om :include-macros true])
  (:require-macros [frontend.utils :refer [component html]]))

(defn text-input
  "<DOC STRING GOES here>."
  [{:keys [input-type on-change id value size disabled? required?] :or {:input-type "text"
                                                                        :size "medium"}}
   owner]
  (reify
    om/IRender
    (render [_]
      (component
        (html
          [:input {:type input-type
                   :on-change on-change
                   :id id
                   :required required?
                   :defaultValue value
                   :disabled disabled?
                   :class size}])))))

(dc/do
  (defcard text-input
    (html
     [:div
      (om/build text-input {:value "Regular little text input"})
      (om/build text-input {:value "Medium sized text input"
                   :size "medium"})
      (om/build text-input {:value "Large sized text input"
                   :size "large"})])))
