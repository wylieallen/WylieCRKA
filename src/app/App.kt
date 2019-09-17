package app

import external.materialui.CssBaseline
import external.reacttransitiongroup.CSSTransition
import external.reacttransitiongroup.TransitionGroup
import pages.about.About
import pages.home.Home
import pages.projects.Projects
import react.*
import react.dom.*
import external.react.router.dom.RouteResultProps
import external.react.router.dom.browserRouter
import external.react.router.dom.route
import external.react.router.dom.switch
import kotlinext.js.requireAll
import starfield.starfield
import kotlin.browser.document

class App : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        starfield(200)

        contactDial(state.open, fun(_, _) { setState{ open = !state.open }})

        div("content-root") {
            CssBaseline {
                browserRouter {
                    route("", render = ::routes)
                }
            }
        }
    }
}

interface AppState : RState {
    var open: Boolean
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

fun main() {
    requireAll(kotlinext.js.require.context("src", true, js("/\\.css$/")))

    render(document.getElementById("root")) {
        app()
    }
}