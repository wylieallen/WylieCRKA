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
                    attrs { item = true; xs = 11; sm = 10; md = 6; lg = 4; xl = 3; container = true; spacing = 8; alignItems = "center"; justify = "center"; }
                    Grid {
                        attrs { item = true; xs = 12; }
                        historyPanel(
                                icon = "fa-baby",
                                panelId = "early",
                                summary = "THE EARLY YEARS",
                                details = arrayOf(
                                        "I was born in San Francisco in the '90s. My earliest exposure to computers came while playing games with my parents on our DOS PC.",
                                        "Growing up I continued exploring computing concepts through after-school web design courses, Flash animation and game modding. Software engineering seemed like a natural fit, but inconsistent math grades discouraged me and I gravitated away from a future in tech.",
                                        "One semester I took a programming class on a lark and fell in love. Succeeding in that class gave me the confidence I needed to power through those once-intimidating math and science prerequisites, and in 2016 I transferred into the University of Florida's Computer Science program."
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
                                        "I discovered a universe of possibility at UF.",
                                        "At first I felt overwhelmed by how much I would need to learn if I wanted to rise to the level of my most accomplished classmates, so I spent time honing my skills with increasingly complex personal projects.",
                                        "I took intensive courses on object-oriented design, UX analysis, graphics programming and software engineering, giving me a strong foundation for designing and developing large systems.",
                                        "My experiences at UF inspired me to reflect on how I could be a productive coder and an effective, collaborative designer. I graduated with a B.S. in Computer Science and a minor in Mathematics in 2018."
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
                                        "Since August 2018 I've been at Masonite's Ybor City office working on Advisar, an internal startup offering a sales and ordering tool for custom-configured Masonite doors.",
                                        "Our Agile development team supports Advisar by designing and implementing features across our stack, from RESTful APIs built on event-driven Spring microservices to single-page React applications that consume those services.",
                                        "I participate in iteration planning meetings, daily stand-ups and weekly retrospectives. Every day I analyze requirements, write stories, and pair program with members of my team to implement features, fix bugs and research new technologies."
                                )
                        )
                    }
                }
            }
        }
    }

    private fun RBuilder.historyPanel(icon: String, panelId: String, summary: String, details: Array<String>) {
        ExpansionPanel {
            attrs { expanded = (props.active && state.openPanel === panelId); onChange = makeExpansionHandler(panelId); className = "history-panel" }
            ExpansionPanelSummary {
                attrs { expandIcon = ExpandMore{}; className = "history-panel-summary" }
                Grid {
                    attrs { container = true; spacing = 8; }
                    Grid {
                        attrs { item = true; xs = 3; sm = 2; md = 1; className = "history-icon-wrapper"; }
                        div("history-icon fas fa-3x $icon") {}
                    }
                    Grid {
                        attrs { item = true; xs = 9; sm = 10; md = 11; justify = "center"; alignItems = "flex-start" }
                        h3{ +summary }
                    }
                }
            }
            ExpansionPanelDetails {
                attrs { className = "history-panel-details" }
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