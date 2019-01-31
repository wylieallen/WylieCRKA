@file:JsModule("react-transition-group/CSSTransition")

package external.reacttransitiongroup

import react.RClass
import react.RProps

@JsName("default")
external val CSSTransition: RClass<CSSTransitionProps>

external interface CSSTransitionProps : RProps {
    var timeout: Int
    var classNames: String
    var key: Any
}

