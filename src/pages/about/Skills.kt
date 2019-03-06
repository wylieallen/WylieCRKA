package pages.about

import external.materialui.*
import external.materialui.icons.ExpandMore
import external.reactslick.Slick
import external.reactslick.Slider
import react.*
import react.dom.*

class Skills : RComponent<RProps, SkillsState>() {
    private val slider = createRef<Slick>()
    private var currentSlideIndex = 0

    init {
        state.openPanel = "early"
    }

    override fun componentDidUpdate(prevProps: RProps, prevState: SkillsState, snapshot: Any) {
        slider.current?.slickGoTo(currentSlideIndex)
    }

    override fun RBuilder.render() {
        div("skills-root") {
            div("skills-mobile-slider") {
                Slider {
                    attrs {
                        centerMode = true
                        ref = slider
                        afterChange = { _, after -> currentSlideIndex = after; }
                        initialSlide = currentSlideIndex
                        arrows = false
                        infinite = false
                    }
                    languagesCard()
                    librariesCard()
                    toolsCard()
                    processesCard()
                }
            }
            div("about-skills") {
                Grid {
                    attrs { container = true; alignItems = "center"; justify = "center"; }
                    Grid {
                        attrs { item = true; container = true; xs = 11; md = 8; alignItems = "center"; justify = "center"; }
                        Grid {
                            attrs { item = true; xs = 6; md = 6; }
                            languagesCard()
                        }
                        Grid {
                            attrs { item = true; xs = 6; md = 6; }
                            librariesCard()
                        }
                        Grid {
                            attrs { item = true; xs = 6; md = 6; }
                            toolsCard()
                        }
                        Grid {
                            attrs { item = true; xs = 6; md = 6; }
                            processesCard()
                        }
                    }
                }
            }
        }
    }

    private fun RBuilder.languagesCard() {
        skillCard(
                summary = "Languages",
                details = arrayOf("Java, Javascript, Kotlin", "HTML, CSS, SQL", "PHP, Python, C, C++")
        )
    }

    private fun RBuilder.librariesCard() {
        skillCard(
                summary = "Libraries and Frameworks",
                details = arrayOf("React, Spring", "JUnit, Selenium, Jest, Enzyme", "OpenGL, JOGL")
        )
    }

    private fun RBuilder.toolsCard() {
        skillCard(
                summary = "Tools",
                details = arrayOf("IntelliJ, Git, npm", "Postgres, Wordpress", "Jira, Confluence")
        )
    }

    private fun RBuilder.processesCard() {
        skillCard(
                summary = "Processes and Paradigms",
                details = arrayOf("Object-oriented design", "Test-driven development", "Pair programming")
        )
    }

    private fun RBuilder.skillCard(summary: String, details: Array<String>) {
        Card {
            CardContent {
                h3 {
                    +summary
                }
                p {
                    details.forEach {
                        +it
                        br{}
                    }
                }
            }
        }
    }
}

interface SkillsState : RState {
    var openPanel: String
}

fun RBuilder.skills() = child(Skills::class) {}