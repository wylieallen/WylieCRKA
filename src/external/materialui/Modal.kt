@file:JsModule("@material-ui/core/Modal")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Modal: RClass<ModalProps>

external interface ModalProps : RProps {
    var open: Boolean
}

