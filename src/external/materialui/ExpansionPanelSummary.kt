@file:JsModule("@material-ui/core/ExpansionPanelSummary")

package external.materialui

import react.RClass
import react.RProps
import react.ReactElement

@JsName("default")
external val ExpansionPanelSummary: RClass<ExpansionPanelSummaryProps>

external interface ExpansionPanelSummaryProps : RProps {
    var expandIcon: ReactElement
    var className: String
}
