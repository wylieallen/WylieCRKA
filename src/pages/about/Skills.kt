package pages.about

import external.materialui.Card
import external.materialui.CardContent
import external.materialui.Grid
import external.reactslick.Slick
import external.reactslick.Slider
import react.*
import react.dom.br
import react.dom.div
import react.dom.h3
import react.dom.p

class Skills : RComponent<RProps, RState>() {
    private val slider = createRef<Slick>()
    private var currentSlideIndex = 0

    override fun componentDidUpdate(prevProps: RProps, prevState: RState, snapshot: Any) {
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
                        attrs { item = true; container = true; xs = 11; md = 8; alignItems = "center"; justify = "center"; spacing = 16; }
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
                            processesCard()
                        }
                        Grid {
                            attrs { item = true; xs = 6; md = 6; }
                            toolsCard()
                        }
                    }
                }
            }
        }
    }

    private fun RBuilder.languagesCard() {
        skillCard(
                summary = "Languages",
                details = arrayOf("Java, JavaScript, Kotlin", "HTML, CSS, SQL", "PHP, Python, C, C++")
        )
    }

    private fun RBuilder.librariesCard() {
        skillCard(
                summary = "Libraries and Frameworks",
                details = arrayOf("React, Spring", "JUnit, Selenium, Jest", "Java2D, OpenGL, JOGL")
        )
    }

    private fun RBuilder.toolsCard() {
        skillCard(
                summary = "Tools",
                details = arrayOf("IntelliJ IDEA, Git, npm", "Postgres, Hibernate, Redis", "Jira, Confluence, Wordpress")
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
            attrs { className = "skill-card" }
            CardContent {
                attrs { className = "skill-card-content" }
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

fun RBuilder.skills() = child(Skills::class) {}