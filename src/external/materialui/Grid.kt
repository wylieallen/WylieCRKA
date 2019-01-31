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
    var id: String
}