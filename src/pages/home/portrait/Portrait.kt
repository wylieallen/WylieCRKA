package pages.home.portrait

import react.RBuilder
import react.dom.div
import react.dom.img

@JsModule("src/pages/home/portrait/portrait.jpg")
external val wylieHeadshot: dynamic

fun RBuilder.portrait() {
    div("portrait-wrapper") {
        img(alt = "Wylie", src = wylieHeadshot, classes = "portrait-img") {}
    }
}
