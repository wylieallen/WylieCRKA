package app

import external.materialui.CssBaseline
import external.reacttransitiongroup.CSSTransition
import external.reacttransitiongroup.TransitionGroup
import pages.about.About
import pages.home.Home
import pages.projects.Projects
import react.*
import react.dom.*
import react.router.dom.RouteResultProps
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import starfield.starfield

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        starfield(200)

        div("content-root") {
            CssBaseline {
                browserRouter {
                    route("", render = ::routes)
                }
            }
        }
    }
}

private fun RBuilder.routes(props: RouteResultProps<RProps>) : ReactElement {
    return TransitionGroup {
            CSSTransition {
                attrs { key = props.location.key; classNames = "fade"; timeout = 750; }
                div {
                    switch(props.location) {
                        route("/", Home::class, exact = true)
                        route("/about", About::class, exact = true)
                        route("/projects", Projects::class, exact = true)
                    }
                }
            }
        }
}

fun RBuilder.app() = child(App::class) {}