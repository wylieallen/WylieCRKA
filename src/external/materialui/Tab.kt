@file:JsModule("@material-ui/core/Tab")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Tab: RClass<TabProps>

external interface TabProps : RProps {
    var label: String
}