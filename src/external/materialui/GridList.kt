@file:JsModule("@material-ui/core/GridList")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val GridList: RClass<GridListProps>

external interface GridListProps : RProps {
    var cellHeight: Int
    var cols: Int
}

