package pages.projects

import external.materialui.*
import external.materialui.icons.Info
import react.dom.*
import external.react.router.dom.routeLink
import kotlinx.html.style
import react.*

@JsModule("src/pages/projects/project.png")
external val projectImage: dynamic

interface ProjectsState : RState {
    var dialogContent: String
    var dialogOpen: Boolean
}

class Projects : RComponent<RProps, ProjectsState>() {
    init {
        state.dialogContent = ""
        state.dialogOpen = false
    }

    override fun RBuilder.render() {
        div("page") {
            Dialog {
                attrs {
                    open = state.dialogOpen
                    onClose = fun(_, _) { setState { dialogOpen = false } }
                    onExited = fun(_, _) { setState { dialogContent = "" } }
                }
                DialogTitle {
                    +"Project ${state.dialogContent}"
                }
                DialogContent {
                    val style = asDynamic()
                    style.width = "100%"
                    style.height = "100%"
                    img {
                        attrs {
                            this.src = projectImage
                            this.style = style
                        }
                    }
                    DialogContentText {
                        +"My Project ${state.dialogContent} project was super cool. It had a lot of stuff. Lorem ipsum dolor sit amet"
                    }
                }
            }
            div("page-content") {
                h2 {
                    +"My Projects"
                }
                Grid {
                    val style = asDynamic()
                    style.marginTop = "2%"
                    style.marginBottom = "2%"
                    attrs { container = true; justify = "center"; this.style = style }
                    Grid {
                        attrs { item = true; container = true;  xs = 11; sm = 9; md = 8; spacing = 40;}
                        listOf(0, 1, 2, 3).map {
                            Grid {
                                attrs { item = true; xs = 12; md = 6; lg = 3}
                                projectCard(projectImage, "Project Name $it", "Project summary here lorem ipsum dolor etc") {
                                    setState{
                                        dialogContent = "$it"
                                        dialogOpen = true
                                    }
                                }
                            }
                        }
                    }
                }
                Grid {
                    val style = asDynamic()
                    style.marginTop = "16px"
                    attrs { id = "home-button-group"; container = true; spacing = 16; justify = "center"; this.style = style }

                    Grid {
                        attrs { item = true; }

                        routeLink(to = "/"){
                            Button {
                                attrs { color = "default"; variant = "contained"; }
                                +"Home"
                            }
                        }
                    }

                    Grid {
                        attrs { item = true; }
                        routeLink(to = "/about") {
                            Button {
                                attrs { color = "primary"; variant = "contained"; }
                                +"About Me"
                            }
                        }
                    }
                }
            }
        }
    }
}



private fun RBuilder.projectCard(imageSrc: dynamic, title: String, summary: String, onClick: () -> Unit) {
    Card {
        attrs { className = "project-card" }
        CardActionArea {
            val style = asDynamic()
            style.padding = "12px"
            attrs { this.onClick = onClick; this.style = style }
            CardMedia {
                attrs { image = imageSrc; className = "project-card-media" }
            }
            CardContent {
                attrs { className = "project-card-content" }
                h3 {
                    +title
                }
                p {
                    +summary
                }
            }
        }
    }
}