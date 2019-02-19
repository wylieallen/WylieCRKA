package pages.about

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

class Skills : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("about-skills") {
            h4 {
                +"Tools I Use"
            }

            div("skills-tile") {
                h5 {
                    +"Languages:"
                }
                p {
                    +"Java, JavaScript, Kotlin"
                    br{}
                    +"HTML, CSS, SQL"
                    br{}
                    +"PHP, Python, C, C++"
                }
            }

            div("skills-tile") {
                h5 {
                    +"Libraries and Frameworks:"
                }
                p {
                    +"React, Spring"
                    br{}
                    +"JUnit, Selenium, Jest, Enzyme"
                    br{}
                    +"OpenGL, JOGL"
                }
            }

            div("skills-tile") {
                h5 {
                    +"Tools:"
                }
                p {
                    +"IntelliJ, Git, npm"
                    br{}
                    +"Postgres, Wordpress"
                    br{}
                    +" Jira, Confluence"
                }
            }

            div("skills-tile") {
                h5 {
                    +"Processes and Paradigms:"
                }
                p {
                    +"Object-oriented analysis and design "
                    br{}
                    +"Test-driven development"
                    br{}
                    +"Pair programming, Agile methodologies"
                }
            }
        }
    }
}

fun RBuilder.skills() = child(Skills::class) {}