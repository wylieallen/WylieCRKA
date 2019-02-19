package pages.about

import react.RBuilder
import react.dom.div
import react.dom.h4
import react.dom.h5

fun RBuilder.history() {
    div("about-history") {
        h4 {
            +"Where I've Been"
        }

        div("history-tile") {
            h5 {
                +"MASONITE INTERNATIONAL"
            }
        }

        div("history-tile") {
            h5 {
                +"UNIVERSITY OF FLORIDA"
            }
        }
    }
}