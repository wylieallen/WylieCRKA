@file:JsModule("@material-ui/core/Paper")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Paper: RClass<PaperProps>

external interface PaperProps : RProps {
    var className: String
}