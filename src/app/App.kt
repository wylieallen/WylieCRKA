package app

import external.materialui.Fade
import external.reacttransitiongroup.CSSTransition
import external.reacttransitiongroup.TransitionGroup
import pages.home.Home
import react.*
import react.dom.*
import react.router.dom.RouteResultProps
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import starfield.starfield
import ticker.Ticker

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        starfield(200)

        div("content-root") {
            browserRouter {
                switch {
                    route("/", Home::class, exact = true)
                    route("/about", Ticker::class, exact = true)
                }
            }
        }
    }
}


fun RBuilder.app() = child(App::class) {}
