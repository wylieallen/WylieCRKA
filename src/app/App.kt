package app

import external.materialui.Typography
import react.*
import react.dom.*
import logo.*
import starfield.starfield
import ticker.*
import kotlin.browser.window

class App : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        div("App-header") {
            logo()
            h2 {
                +"Welcome to React with Kotlin"
            }
        }
        p("App-intro") {
            +"To get started, edit "
            code { +"app/App.kt" }
            +" and save to reload."
        }
        starfield(window.innerWidth, window.innerHeight, 200)

        p("App-ticker") {
            ticker()
        }
        Typography {
            attrs { variant = "h4"; align = "center"; color = "textPrimary"; paragraph = true; }
            +"Yep"
        }
    }
}

fun RBuilder.app() = child(App::class) {}
