package pages.about

import external.materialui.Grid
import external.reactslick.Slick
import external.reactslick.Slider
import react.*
import react.dom.*

class Values : RComponent<RProps, RState>() {
    private val slider = createRef<Slick>()
    private var currentSlideIndex = 0

    override fun RBuilder.render() {
        div("about-values") {
            div("about-mobile-slider") {
                Slider {
                    attrs { centerMode = true; ref = slider; afterChange = { _, after -> currentSlideIndex = after; }; initialSlide = currentSlideIndex; arrows = false; dots = true; }
                    valuePillars()
                }
            }

            Grid {
                attrs { container = true; justify = "center"; alignItems = "center"}
                Grid {
                    attrs { item = true; xs = 11; container = true; justify = "center"; direction = "column"; alignItems = "center"; }
                    Grid {
                        attrs { item = true; }
                        div("value-pillars") {
                            valuePillars()
                        }
                    }
                }
            }

        }
    }

    override fun componentDidUpdate(prevProps: RProps, prevState: RState, snapshot: Any) {
        slider.current?.slickGoTo(currentSlideIndex)
    }

    private fun RBuilder.valuePillars() {
        valuePillar(
                title = "Quality Code",
                tagline = "I'm playing the long game.",
                icon = "fa-code",
                content = "That means writing straightforward, reliable, and extensible code so today's solution won't become tomorrow's problem."
        )

        valuePillar(
                title = "Effective Design",
                tagline = "My apps have a lot to say.",
                icon = "fa-calculator fa-rotate-270",
                content = "I convey intent, possibility, and consequence through intuitive, dynamic interfaces so our users can hit the ground running."
        )

        valuePillar(
                title = "Users First",
                tagline = "There's more to UX than UI.",
                icon = "fa-user",
                content = "Thanks to rapid prototyping, powerful analytics, and direct user engagement, I'm always on top of what our stakeholders need."
        )
    }

    private fun RBuilder.valuePillar(title: String, tagline: String, icon: String, content: String) {
        div("value-pillar") {
            h3("value-pillar-title") {
                span { +title }
            }
            div("value-pillar-icon fas fa-5x $icon") {}
            strong("value-pillar-tagline") {
                span { +tagline }
            }
            p("value-pillar-content") {
                span { +content }
            }
        }
    }
}

fun RBuilder.values() = child(Values::class) {}