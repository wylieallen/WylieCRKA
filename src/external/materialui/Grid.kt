@file:JsModule("@material-ui/core/Grid")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Grid: RClass<GridProps>

external interface GridProps : RProps{
    var spacing: Int
    var justify: String
    var container: Boolean
    var item: Boolean
    var direction: String
    var alignItems: String
    var id: String
    var xs: Int
    var sm: Int
    var md: Int
    var lg: Int
    var xl: Int
    var className: String
    var style: dynamic
}