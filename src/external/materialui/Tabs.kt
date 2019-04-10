@file:JsModule("@material-ui/core/Tabs")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Tabs: RClass<TabsProps>

external interface TabsProps : RProps {
    var value: dynamic
    var onChange: (Any, Int) -> Unit
    var indicatorColor: String
    var textColor: String
    var variant: String
    var centered: Boolean
}

