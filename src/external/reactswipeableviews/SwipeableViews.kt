@file:JsModule("react-swipeable-views")

package external.reactswipeableviews

import react.RClass
import react.RProps

@JsName("default")
external val SwipeableViews : RClass<SwipeableViewsProps>

external interface SwipeableViewsProps : RProps {
    var axis: String
    var index: Int
    var onChangeIndex: (Int) -> Unit
    var disabled: Boolean
    var slideClassName: String
}

