@file:JsModule("@material-ui/core/ExpansionPanel")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val ExpansionPanel: RClass<ExpansionPanelProps>

external interface ExpansionPanelProps : RProps {
    var expanded: Boolean
    var onChange: (event: dynamic, expanded: Boolean) -> Unit
    var className: String
}