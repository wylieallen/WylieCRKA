@file:JsModule("nuka-carousel")

package external.nukacarousel

import react.RClass
import react.RProps

@JsName("default")
external val Carousel: RClass<CarouselProps>

external interface CarouselProps : RProps {
    var cellAlign: String
    var heightMode: String
}
