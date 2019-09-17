@file:JsModule("@material-ui/core/Modal")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Modal: RClass<ModalProps>

external interface ModalProps : RProps {
    var onClose: () -> Unit
    var onExited: () -> Unit
    var open: Boolean
}

