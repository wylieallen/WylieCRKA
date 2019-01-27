@file:JsModule("@material-ui/core/Typography")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Typography: RClass<TypographyProps>

external interface TypographyProps : RProps {
    var variant: String
    var align: String
    var color: String
    var paragraph: Boolean
}
