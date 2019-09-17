@file:JsModule("@material-ui/core/Tooltip")
package external.materialui

import react.*

@JsName("default")
external val Tooltip: RClass<TooltipProps>

external interface TooltipProps : RProps {
    var title: String
}

