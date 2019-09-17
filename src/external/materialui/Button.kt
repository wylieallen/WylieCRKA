@file:JsModule("@material-ui/core/Button")
package external.materialui

import react.*

@JsName("default")
external val Button: RClass<ButtonProps>

external interface ButtonProps : RProps {
    var color: String
    var variant: String
    var href: String
    var target: String
    var style: dynamic
}

