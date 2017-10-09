(ns kii.device.keyboard
  (:require [clojure.string :as s]))

(def devices
  [{:vendor-id 0x1c11 :product-id 0xb04d :flashable? false} ;Board
   {:vendor-id 0x1c11 :product-id 0xb007 :flashable? true}  ;Boot
   {:vendor-id 0x1209 :product-id 0x01c0 :flashable? false} ;Registered Board
   {:vendor-id 0x1209 :product-id 0x01cb :flashable? true}]) ;Registered Boot

(def keyboards
  [{:display "Infinity Ergodox"
    :names   ["MDErgo1" "Infinity_Ergodox"]
    :layouts ["Default"]
    :image   "ergodox.png"
    :visuals-enabled? false
    ;; TODO: layout-detail
    }
   {:display       "Infinity 60% LED"
    :names         ["MD1.1" "Infinity_60%_LED"]
    :layouts       ["Standard" "Hacker" "Alphabet"]
    :image         "infinity-led.png"
    :visuals-enabled? false
    :layout-detail {"Standard"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2d]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25]
                            [:2.25 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.75d]
                            [:1.25d :1.25d :1.25d :6.25d :1.25d :1.25d :1.25d :1.25d]
                            ]}
                    "Hacker"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1d :1d]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25]
                            [:2.25 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75d :1d]
                            [:1.5d :1d :1.5d :6d :1.5d :1d :1d :1.5d]]}
                    "Alphabet"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1d :1d]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25]
                            [:2.25 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75d :1d]
                            [:1.25d :1.25d :1.25d :6.25d :1.25d :1.25d :1.25d :1.25d]
                            ]}
                    }}
   {:display       "Infinity 60%"
    :names         ["MD1" "Infinity_60%"]
    :layouts       ["Standard" "Hacker"]
    :image         "infinity.png"
    :visuals-enabled? false
    :layout-detail {"Standard"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25]
                            [:2.25 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75 :1]
                            [:1.25d :1.25d :1.25d :6.25d :1.25d :1.25d :1.25d :1.25d]
                            ]}
                    "Hacker"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25]
                            [:2.25 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75 :1]
                            [:1.5d :1d :1.5d :6d :1.5d :1d :1d :1.5d]]}
                    }}
   {:display       "WhiteFox"
    :names         ["WhiteFox"]
    :layouts       ["The True Fox" "Aria" "Iso" "Vanilla" "Jack of All Trades" "Winkeyless"]
    :image         "whitefox.png"
    :visuals-enabled? false
    :layout-detail {
                    "The True Fox"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1d :1d :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5d :1]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25d :1]
                            [:2.25d :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75d :1d :1]
                            [:1.25d :1.25d :1.25d :6.25d :1.25d :1.25d :0.5s :1 :1 :1]
                            ]}
                    "Aria"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2d :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5d :1]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25d :1]
                            [:2.25d :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75d :1d :1]
                            [:1.25d :1.25d :1.25d :6.25d :1.25d :1.25d :0.5s :1 :1 :1]
                            ]}
                    "Iso"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2d :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5s :1]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1d :1.25d :1]
                            [:1.25d :1d :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75d :1d :1]
                            [:1.25d :1.25d :1.25d :6.25d :1d :1d :1d :1 :1 :1]
                            ]}
                    "Vanilla"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2d :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5d :1]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25d :1]
                            [:2.25d :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75d :1d :1]
                            [:1.25d :1.25d :1.25d :6.25d :1d :1d :1d :1 :1 :1]
                            ]}
                    "Jack of All Trades"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2d :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5d :1]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25d :1]
                            [:2.25d :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.75d :1]
                            [:1.25d :1.25d :1.25d :6.25d :1.25d :1.25d :0.5s :1 :1 :1]
                            ]}
                    "Winkeyless"
                    {:rows [0 1 2 3 4]
                     :keys [[:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2d :1]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5d :1]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25d :1]
                            [:2.25d :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.75d :1d :1]
                            [:1.5d :1.5d :7d :1.5d :1.5d :1 :1 :1]
                            ]}
                    }}
   {:display "K-Type"
    :names ["KType" "K-Type"]
    :layouts ["Standard"]
    :image "k-type.png"
    :layout-detail {"Standard"
                    {:rows [0 1.5 2.5 3.5 4.5 5.5]
                     :keys [[:1 :1s :1 :1 :1 :1 :0.5s :1 :1 :1 :1 :0.5s :1 :1 :1 :1 :0.5s :1 :1 :1]
                            [:1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2 :0.5s :1 :1 :1 ]
                            [:1.5 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1.5 :0.5s :1 :1 :1]
                            [:1.75 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.25]
                            [:2.25 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :2.75 :1.5s :1]
                            [:1.25 :1.25 :1.25 :6.25 :1.25 :1.25 :1.25 :1.25 :0.5s :1 :1 :1]
                            ]}}
    }])

(defn get-ic-device
  [device]
  (let [vid (:vendor-id device)
        pid (:product-id device)]
    (first (filter #(and (= (:vendor-id %) vid)
                         (= (:product-id %) pid))
                   devices))))

(defn ic?
  [device]
  (some? (get-ic-device device)))

(defn product->keyboard
  [product]
  (or
   (first (filter (fn [k] (some #(s/includes? product %) (:names k))) keyboards))
   {:display "Unknown"
    :names []
    :layouts []
    :image "unknown.png"}))

(defn flashable?
  [device]
  (if-let [icd (get-ic-device device)]
    (true? (:flashable? icd))
    false))
