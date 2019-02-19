@file:JsModule("react-slick")

package external.reactslick

import react.RClass
import react.RProps

@JsName("default")
external val Slider: Slick

external interface Slick : RClass<SliderProps> {
    fun slickNext()
    fun slickGoTo(index: Int)
}

external interface SliderProps : RProps {
    var centerMode: Boolean
    var afterChange: (beforeIndex: Int, afterIndex: Int) -> Unit
    var initialSlide: Int
    var arrows: Boolean
}