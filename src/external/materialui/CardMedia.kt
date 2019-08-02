@file:JsModule("@material-ui/core/CardMedia")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val CardMedia: RClass<CardMediaProps>

external interface CardMediaProps : RProps {
    var className: String
    var image: String
    var title: String
    var component: String
}
