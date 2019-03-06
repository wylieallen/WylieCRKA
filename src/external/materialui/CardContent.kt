@file:JsModule("@material-ui/core/CardContent")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val CardContent: RClass<CardContentProps>

external interface CardContentProps : RProps {
    var className: String
}
