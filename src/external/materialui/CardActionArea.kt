@file:JsModule("@material-ui/core/CardActionArea")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val CardActionArea: RClass<CardActionAreaProps>

external interface CardActionAreaProps : RProps {
    var onClick: () -> Unit
    var style: dynamic
}

