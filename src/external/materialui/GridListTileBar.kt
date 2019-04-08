@file:JsModule("@material-ui/core/GridListTileBar")

package external.materialui

import react.RClass
import react.RProps
import react.ReactElement

@JsName("default")
external val GridListTileBar : RClass<GridListTileBarProps>

external interface GridListTileBarProps : RProps {
    var title: String
    var subtitle: ReactElement
    var actionIcon: ReactElement
}

