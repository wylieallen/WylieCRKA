@file:JsModule("@material-ui/core/ExpansionPanelDetails")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val ExpansionPanelDetails: RClass<ExpansionPanelDetailsProps>

external interface ExpansionPanelDetailsProps : RProps {
    var className: String
}