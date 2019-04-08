@file:JsModule("@material-ui/core/IconButton")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val IconButton : RClass<IconButtonProps>

external interface IconButtonProps : RProps {
    var onClick: () -> Unit
}
