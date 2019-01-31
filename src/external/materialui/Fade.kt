@file:JsModule("@material-ui/core/Fade")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Fade: RClass<FadeProps>

external interface FadeProps : RProps {
    @JsName("in")
    var active: Boolean
    var timeout: Int
}