package portrait

import react.RBuilder
import react.dom.div
import react.dom.img

@JsModule("src/portrait/portrait.jpg")
external val wylieHeadshot: dynamic

fun RBuilder.portrait() {
    div("portrait-wrapper") {
        img(alt = "Wylie", src = wylieHeadshot, classes = "portrait-img") {}
    }
}
