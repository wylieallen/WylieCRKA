@file:JsModule("@material-ui/lab")

package external.materialui

import react.*

@JsName("SpeedDial")
external val SpeedDial: RClass<SpeedDialProps>

external interface SpeedDialProps : RProps {
    var ariaLabel: String
    var direction: String
    var icon: ReactElement
    var open: Boolean
    var onClick: (dynamic, String) -> Unit
    var style: dynamic
}

@JsName("SpeedDialAction")
external val SpeedDialAction: RClass<SpeedDialActionProps>

external interface SpeedDialActionProps : RProps {
    var icon: ReactElement
    var href: String
    var target: String
    var tooltipTitle: String
}

@JsName("SpeedDialIcon")
external val SpeedDialIcon: RClass<SpeedDialIconProps>

external interface SpeedDialIconProps : RProps {
    var icon: ReactElement
    var openIcon: ReactElement
}

