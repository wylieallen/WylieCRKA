@file:JsModule("@material-ui/core/Dialog")

package external.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Dialog: RClass<DialogProps>

external interface DialogProps : RProps {
    var open: Boolean
    var onClose: (dynamic, String) -> Unit
    var onExited: (dynamic, String) -> Unit
    var fullScreen: Boolean
}

