package pages.projects

import external.materialui.*
import external.materialui.icons.Info
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import external.react.router.dom.routeLink

@JsModule("src/pages/projects/project.png")
external val projectImage: dynamic


class Projects : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("page") {
            div("page-content") {
                h2 {
                    +"My Projects"
                }
                Grid {
                    attrs { container = true; justify = "center"; }
                    Grid {
                        attrs { item = true; xs = 11; sm = 9; md = 8; lg = 7; xl = 6; spacing = 40;}
                        GridList{
                            attrs { cellHeight = 200; cols = 3; }
                            GridListTile {
                                attrs { cols = 1; }
                                img(src = projectImage, alt = "Project"){}
                                GridListTileBar {
                                    attrs {
                                        title = "Wylaga"
                                        subtitle = span{+"A Galaga-inspired 2D space shooter"}
                                        actionIcon = IconButton{
                                            attrs { onClick = {println("Click")} }
                                            Info{}
                                        }
                                    }
                                }
                            }
                            GridListTile {
                                attrs { cols = 1; }
                                img(src = projectImage, alt = "Project"){}
                            }
                            GridListTile {
                                attrs { cols = 1; }
                                img(src = projectImage, alt = "Project"){}
                            }
                            GridListTile {
                                attrs { cols = 1; }
                                img(src = projectImage, alt = "Project"){}
                            }
                            GridListTile {
                                attrs { cols = 1; }
                                img(src = projectImage, alt = "Project"){}
                            }
                            GridListTile {
                                attrs { cols = 1; }
                                img(src = projectImage, alt = "Project"){}
                            }
                        }
                    }
                }
                routeLink(to = "/"){
                    Button {
                        attrs { color = "default"; variant = "contained"; }
                        +"Home"
                    }
                }
            }
        }
    }
}