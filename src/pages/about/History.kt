package pages.about

import external.materialui.ExpansionPanel
import external.materialui.ExpansionPanelDetails
import external.materialui.ExpansionPanelSummary
import external.materialui.Grid
import external.materialui.icons.ExpandMore
import react.*
import react.dom.*

class History : RComponent<HistoryProps, HistoryState>() {
    init {
        state.openPanel = "early"
    }

    private fun makeExpansionHandler(panelId: String): (dynamic, Boolean) -> Unit {
        return fun(_, _) {
            setState { openPanel = panelId }
        }
    }

    override fun RBuilder.render() {
        div("history-grid") {
            Grid {
                attrs { container = true; alignItems = "center"; justify = "center"; }
                Grid {
                    attrs { item = true; xs = 12; sm = 11; md = 9; lg = 6; xl = 5; container = true; spacing = 8; alignItems = "center"; justify = "center"; }
                    Grid {
                        attrs { item = true; xs = 12; }
                        historyPanel(
                                icon = "fa-baby",
                                panelId = "early",
                                summary = "THE EARLY YEARS",
                                details = arrayOf(
                                        "I was born in San Francisco in the '90s. My parents were personal computing hobbyists who gave me a lot of early exposure to computers starting with games on our DOS IBM.",
                                        "My dad's job kept us moving around a lot until we eventually settled down in my mom's hometown of Tampa, Florida.",
                                        "I began exploring programming while growing up through after-school web design courses, Flash animation and game modding."
                                )
                        )
                    }
                    Grid {
                        attrs { item = true; xs = 12; }
                        historyPanel(
                                icon = "fa-graduation-cap",
                                panelId = "uf",
                                summary = "UNIVERSITY OF FLORIDA",
                                details = arrayOf(
                                        "I moved to Gainesville to attend UF and graduated with a B.S. in Computer Science in May 2018. My technical electives included OOP, Design Patterns, UX Design, AI and Heuristics, and Multimedia Production.",
                                        "I worked in teams on larger-scale software systems, which inspired me to think about what makes a great software engineer beyond mastery of syntax.",
                                        "Many of my personal projects, like Wylaga, Taluvo and DisplayKT, can trace their origins back to UF class material and coursework."
                                )
                        )
                    }
                    Grid {
                        attrs { item = true; xs = 12; }
                        historyPanel(
                                icon = "fa-door-open",
                                panelId = "masonite",
                                summary = "MASONITE INTERNATIONAL",
                                details = arrayOf(
                                        "Since August 2018 I've been at Masonite's Ybor City office working on Advisar, a sales and ordering tool for custom-configured Masonite doors.",
                                        "I work on an Agile team that supports Advisar's suite of web applications by completing stories across a stack that includes React UIs and Spring-based microservices."
                                )
                        )
                    }
                }
            }
        }
    }

    private fun RBuilder.historyPanel(icon: String, panelId: String, summary: String, details: Array<String>) {
        ExpansionPanel {
            attrs { expanded = (props.active && state.openPanel === panelId); onChange = makeExpansionHandler(panelId) }
            ExpansionPanelSummary {
                attrs { expandIcon = ExpandMore{} }
                Grid {
                    attrs { container = true; spacing = 8; }
                    Grid {
                        attrs { item = true; xs = 3; sm = 2; md = 1; }
                        div("history-icon fas fa-3x $icon") {}
                    }
                    Grid {
                        attrs { item = true; xs = 9; sm = 10; md = 11; justify = "center"; alignItems = "flex-start" }
                        h3{ +summary }
                    }
                }
            }
            ExpansionPanelDetails {
                details.forEach {
                    p{+it}
                }
            }
        }
    }
}

interface HistoryProps : RProps {
    var active: Boolean
}

interface HistoryState : RState {
    var openPanel: String
}

fun RBuilder.history(isActive: Boolean) = child(History::class) {attrs {active = isActive}}