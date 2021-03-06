package pages.home

import external.materialui.Button
import external.materialui.Fade
import external.materialui.Grid
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import external.react.router.dom.routeLink
import pages.home.portrait.portrait

class Home : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        Fade {
            attrs { active = true; timeout = 1000; }
            div("page") {
                div("page-content home-content") {
                    h2 {
                        +"Wylie Allen"
                    }

                    h4 {
                        +"Full-Stack Engineer"
                    }

                    portrait()

                    p("App-intro") {
                        +"I make web apps by day and games by night."
                    }

                    Grid {
                        attrs { id = "home-button-group"; container = true; spacing = 16; justify = "center" }

                        Grid {
                            attrs { item = true; }

                            routeLink(to = "/about"){
                                Button {
                                    attrs { color = "default"; variant = "contained"; }
                                    +"About Me"
                                }
                            }
                        }

                        Grid {
                            attrs { item = true; }
                            routeLink(to = "/projects") {
                                Button {
                                    attrs { color = "primary"; variant = "contained"; }
                                    +"My Projects"
                                }
                            }
                        }
                    }

                    div("privacy-policy-link") {
                        routeLink(to = "/privacy") {
                            + "Privacy Policy"
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.home() = child(Home::class) {}
