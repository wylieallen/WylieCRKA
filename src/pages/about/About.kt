package pages.about

import external.materialui.Button
import external.materialui.Grid
import external.materialui.Tab
import external.materialui.Tabs
import external.reactswipeableviews.SwipeableViews
import react.*
import react.dom.*
import external.react.router.dom.routeLink

interface AboutState : RState {
    var tabIndex: Int
}

class About : RComponent<RProps, AboutState>() {

    init {
        state.tabIndex = 1
    }

    override fun componentDidMount() {
        // Workaround for broken transition on initial tab change
        setState{tabIndex = 0}
    }

    override fun RBuilder.render() {
        div("page") {
            div("page-content") {
                Grid {
                    attrs { container = true; justify = "center"; direction = "column"; alignItems = "center"; }
                    Grid {
                        attrs { item = true; }
                        h2 {
                            +"About Me"
                        }
                    }
                }
                div("about-tabs") {
                    Tabs {
                        attrs {
                            value = state.tabIndex
                            onChange = { _, index: Int -> setState { tabIndex = index } }
                            indicatorColor = "primary"
                            textColor = "primary"
                            variant = "fullWidth"
//                            centered = true
                        }
                        Tab { attrs { label = "Values" } }
                        Tab { attrs { label = "Skills" } }
                        Tab { attrs { label = "Stories" } }
                    }
                }

                SwipeableViews {
                    attrs {
                        axis = "x"
                        index = state.tabIndex
                        disabled = true
                        slideClassName = "about-slide"
                    }

                    values()

                    skills()

                    history(state.tabIndex == 2)
                }
                div("about-nav") {
                    routeLink(to = "/") {
                        Button {
                            attrs { color = "default"; variant = "contained"; }
                            +"Home"
                        }
                    }
                }
            }
        }
    }
}