@file:JsModule("@material-ui/core/GridListTile")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val GridListTile : RClass<GridListTileProps>

external interface GridListTileProps : RProps {
    var cols: Int
}

