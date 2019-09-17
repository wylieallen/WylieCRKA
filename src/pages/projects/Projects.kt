package pages.projects

import external.materialui.*
import external.materialui.icons.Close
import react.dom.*
import external.react.router.dom.routeLink
import external.reactslick.Slick
import external.reactslick.Slider
import react.*

@JsModule("src/pages/projects/crka-about.png")
external val crkaAbout: dynamic

@JsModule("src/pages/projects/crka-meta.png")
external val crkaMeta: dynamic

@JsModule("src/pages/projects/crka-title.png")
external val crkaTitle: dynamic

@JsModule("src/pages/projects/senior-asteroids.png")
external val seniorAsteroids: dynamic

@JsModule("src/pages/projects/senior-enemy.png")
external val seniorEnemy: dynamic

@JsModule("src/pages/projects/senior-loot.png")
external val seniorLoot: dynamic

@JsModule("src/pages/projects/taluvo-large.png")
external val taluvoLarge: dynamic

@JsModule("src/pages/projects/taluvo-small.png")
external val taluvoSmall: dynamic

@JsModule("src/pages/projects/taluvo-title.png")
external val taluvoTitle: dynamic

@JsModule("src/pages/projects/wylaga-group.png")
external val wylagaGroup: dynamic

@JsModule("src/pages/projects/wylaga-logo.png")
external val wylagaLogo: dynamic

@JsModule("src/pages/projects/wylaga-player.png")
external val wylagaPlayer: dynamic

val crkaImages = listOf(crkaTitle, crkaAbout, crkaMeta)
val seniorImages = listOf(seniorEnemy, seniorAsteroids, seniorLoot)
val taluvoImages = listOf(taluvoSmall, taluvoLarge, taluvoTitle)
val wylagaImages = listOf(wylagaGroup, wylagaPlayer, wylagaLogo)

class Project(val name: String,
              val tagline: (RBuilder) -> Unit,
              val description: (RBuilder) -> Unit,
              val background: (RBuilder) -> Unit,
              val highlights: (RBuilder) -> Unit,
              val images: List<dynamic>,
              val github: String,
              val demo: Demo? = null)

class Demo(val url: dynamic,
           val tooltip: String,
           val inBrowser: Boolean)

private fun RBuilder.wylagaTagline() {
    i { + "Wylaga" }
    + " is a series of top-down 2D action games inspired by arcade classics such as "
    i { + "Centipede"}
    + " and "
    i { + "Galaga"}
    + ". Built on a custom engine with browser- and JVM-based implementations."
}

private fun RBuilder.wylagaDescription() {
    p {
        i { + "Wylaga" }
        + " is a series of top-down 2D action games inspired by arcade classics such as "
        a(href = "https://en.wikipedia.org/wiki/Centipede_(video_game)", target = "_blank") { + "Centipede"}
        + " and "
        a(href = "https://en.wikipedia.org/wiki/Galaga", target = "_blank") { + "Galaga"}
        + ". There are four distinct iterations of "
        i { + "Wylaga" }
        + ": a desktop JVM application written in Java, a browser-based implementation written in JavaScript, and a multiplatform Kotlin application that can deploy to either environment."
    }
}

private fun RBuilder.wylagaBackground() {
    p {
        + "I began what would become "
        i { + "Wylaga" }
        + " in the summer of 2017. I'd set out to apply the skills I'd learned"
        + " in recent software engineering and multimedia production courses with a project that I could specify and design myself from the ground up."
        + " My goal was to create a pick-up-and-play experience that married fun, fast, and intuitive gameplay with colorful, dynamic visuals."
    }

    p {
        + "I reached a point where I was proud of "
        i { + "Wylaga" }
        + "'s user experience but dissatisfied with its portability, so in 2018 I set out to bring it to web browsers with a rendition built on JavaScript and the HTML5 Canvas API."
        + " As the "
        i { + "WylagaJS"}
        + " codebase grew I often found myself frustrated by tedious refactoring that would've been trivially accomplished in Java,"
        + " so I started researching statically-typed alternatives to vanilla JavaScript. I considered a few languages, including TypeScript and Haxe,"
        + " before settling on Kotlin for its added benefit of Java interoperability, allowing me to use the same code for JVM- or browser-based applications."
    }

    p {
        i { + "WylagaKT" }
        + " is the latest iteration of the series, a multiplatform Kotlin project that can be played in the browser or downloaded and run as a JVM desktop application."
        + " If you're on a device with a keyboard, give the demo a try below!"
    }
}

private fun RBuilder.wylagaHighlights() {
    p {
        + "Every version of "
        i { + "Wylaga" }
        + " uses a Model-View-Controller architecture to decouple game logic from platform-specific rendering and input handling details."
        + " The game executes its main loop roughly 60 times per second. First, controllable entities are updated based on input from the player or their AI pilots."
        + " The game then advances its state to the next logic frame: all entities are repositioned based on their direction and velocity, and then checked against each other for collisions."
        + " Every entity is represented by an "
        a (href = "https://developer.mozilla.org/en-US/docs/Games/Techniques/3D_collision_detection#Axis-aligned_bounding_boxes", target = "_blank") {
            + "axis-aligned bounding box"
        }
        + ", a slightly inaccurate but very performant approximation of entities' shapes. When two entities collide, the game applies the appropriate effects"
        + " (e.g., if a projectile overlaps with a ship, the projectile despawns and the ship takes damage)."
        + " Finally, the game cleans up and spawns new entities and despawns expired entities as necessary."
    }

    p {
        + "When the model finishes, the view layer updates sprite positions and animation states and then re-renders the scene using a basic implementation of a data structure called a "
        a (href = "https://en.wikipedia.org/wiki/Scene_graph", target = "_blank") {
            + "scene graph"
        }
        + ". "
        i { + "Wylaga" }
        + "'s visuals are represented by a directed acyclic graph in which each node corresponds to a fundamental graphical operation."
        + " An object providing an interface to a graphics API is passed into the root of the structure and draws the scene as the graph is traversed:"
        + " intermediate nodes apply transformations and control the order in which their children are drawn while terminal nodes draw images, shapes, or text."
        + " The scene graph supports runtime flexibility, affords efficient sharing of resources, and provides a layer of abstraction that enables portability between specific graphics APIs."
    }
}

private fun RBuilder.taluvoTagline() {
    i { + "Taluvo" }
    + " is a desktop strategy game implemented as a Java desktop application."
    + " Compete against local human players or AI-controlled opponents for control of a dynamically growing world."
}

private fun RBuilder.taluvoDescription() {
    p {
        i { + "Taluvo" }
        + " is a desktop strategy game inspired by the board game "
        a(href = "https://boardgamegeek.com/boardgame/24508/taluva", target = "_blank") {
            + "Taluva"
        }
        + ". Develop a new civilization on an emerging volcanic island while competing against local human players or AI-controlled opponents."
        i { + " Taluvo" }
        + " is written in Java and uses a custom, dynamically resizable GUI supporting mouse and touch input with arbitrary window sizes."
    }
}

private fun RBuilder.taluvoBackground() {
    p {
        i { + "Taluvo" }
        + " is based on a formative school project, "
        i { + "TigerIsland" }
        + ", from my Intro to Software Engineering class with professor Dave Small at UF."
        + " Students were grouped into teams of six and tasked with designing and developing networked strategy game clients with intelligent agents that would autonomously play against each other in a class tournament."
        + " Our team's "
        i { + "TigerIsland" }
        + " client performed at the top of the class, but it had plenty of glaring flaws under the hood: the codebase was incomprehensibly disorganized, inflexible, and poorly optimized."
        + " Over winter break, I set out to redesign our program from the ground up with clean architecture and optimal performance in mind."
    }
}

private fun RBuilder.taluvoHighlights() {
    p {
        i { + "TigerIsland" }
        + " ran much slower than I would've liked due to the fact that the GUI and game logic subsystems were hideously intertwined, so I used a strict Model-View-Controller architecture to ensure "
        i { + "Taluvo" }
        + "'s concerns were properly separated into distinct subsystems."
        + " AI computations take place on worker threads, allowing the GUI to remain responsive during intense analysis."
        + " The performance gains were dramatic: in a benchmark I found that "
        i { + "TigerIsland" }
        + " took between 100 and 500 milliseconds to take a turn, whereas "
        i { + "Taluvo" }
        + " resolved its turns between 0.2 and 3 milliseconds."
        i { + " Taluvo" }
        + "'s AI can complete an entire game in the time it takes "
        i { + "TigerIsland" }
        + "'s AI to decide on a single move."
    }
}

private fun RBuilder.crkaTagline() {
    + "The site you're on right now is "
    i { + "wylieallen.dev" }
    + ", my personal portfolio and digital resume. It's a React UI written primarily in Kotlin using "
    i { + "create-react-kotlin-app" }
    + " and other Kotlin wrappers for JavaScript libraries."
}

private fun RBuilder.crkaDescription() {
    p {
        + "The site you're on right now is "
        i { + "wylieallen.dev" }
        + ", my personal portfolio and digital resume. It's a React UI written primarily in Kotlin using "
        a(href = "https://github.com/JetBrains/create-react-kotlin-app", target = "_blank") { + "create-react-kotlin-app" }
        + " and other Kotlin wrappers for JavaScript libraries."
    }
}

private fun RBuilder.crkaBackground() {
    p {
        + "I started work on this site so it could serve as a showcase for my skills, interests, and personal projects."
        + " This project was fairly straightforward with a limited scope, so I decided to take the opportunity to experiment with some new languages and packages."
    }
}

private fun RBuilder.crkaHighlights() {
    p {
        + "The source code for "
        i { + "wylieallen.dev" }
        + " consists primarily of Kotlin and CSS."
        + " The animated canvas background is based on the starfield particle effect from "
        i { + "Wylaga"}
        + ". Page transitions are implemented using CSS transforms and the "
        a(href = "https://reactcommunity.org/react-transition-group/", target = "_blank") { + "react-transition-group"}
        + " package. The site uses a variety of components from "
        a(href = "https://material-ui.com/", target = "_blank") { + "Material-UI" }
        + " and "
        a(href = "https://react-slick.neostack.com/", target = "_blank") { + "react-slick" }
        + "."
    }
}

private fun RBuilder.seniorTagline() {
    + "My capstone senior project for UF was a game inspired by my earlier project, "
    i { + "Wylaga" }
    + ". Explore a 3D space, negotiate asteroid fields, and compete against rival pilots. "
    + " Built on a custom OpenGL graphics engine."
}

private fun RBuilder.seniorDescription() {
    p {
        + "My capstone senior project for UF was a game, "
        i { + "The Last Human"}
        + ", inspired by my earlier project, "
        i { + "Wylaga" }
        + ". Explore a 3D space, negotiate asteroid fields, and compete against rival pilots. "
        + "This was a group project - my main contributions were the collision detection and graphics rendering systems."
    }
}

private fun RBuilder.seniorBackground() {
    p {
        + "I originally planned on rewriting and extending "
        i { + "Wylaga" }
        + " for my senior project. After I brought a couple classmates, Ross Goldblum and Zachery Scribner, onto the project,"
        + " our faculty advisor, Dave, suggested we expand the project's scope accordingly by moving from 2D graphics to 3D."
        + " We evaluated a few options and settled on using "
        a(href = "https://en.wikipedia.org/wiki/Java_OpenGL", target = "_blank") { + "JOGL" }
        + ", a library of Java bindings for OpenGL. "
    }
}

private fun RBuilder.seniorHighlights() {
    p {
        + "The migration from 2D to 3D introduced new challenges for our team. We were used to having direct control over the pixels being displayed,"
        + " but now we were trying to generate visuals indirectly through several layers of abstraction. I had to make enough sense out of OpenGL concepts to provide a performant interface to the rest of the team."
    }
    p {
        + "Fortunately, the scene graph architecture borrowed from "
        i { + "Wylaga" }
        + " helped alleviate many of these concerns."
        + " The scene graph provided a wrapper encapsulating messy OpenGL implementation details, allowing us to work with the graphics subsystem"
        + " in terms of intuitive concepts such as models, textures and cameras."
    }
}

val projects = listOf(
        Project(name = "Wylaga",
                tagline = RBuilder::wylagaTagline,
                description = RBuilder::wylagaDescription,
                background = RBuilder::wylagaBackground,
                highlights = RBuilder::wylagaHighlights,
                images = wylagaImages,
                github = "https://github.com/wylieallen/WylagaKT",
                demo = Demo("/WylagaKT-Demo/", "Requires keyboard and 720p display", true)),
        Project(name = "Taluvo",
                tagline = RBuilder::taluvoTagline,
                description = RBuilder::taluvoDescription,
                background = RBuilder::taluvoBackground,
                highlights = RBuilder::taluvoHighlights,
                images = taluvoImages,
                github = "https://github.com/wylieallen/Taluvo",
                demo = Demo("/Taluvo.jar", "Requires JRE", false)),
        Project(name = "wylieallen.dev",
                tagline = RBuilder::crkaTagline,
                description = RBuilder::crkaDescription,
                background = RBuilder::crkaBackground,
                highlights = RBuilder::crkaHighlights,
                images = crkaImages,
                github = "https://github.com/wylieallen/WylieCRKA"),
        Project(name = "Senior Project",
                tagline = RBuilder::seniorTagline,
                description = RBuilder::seniorDescription,
                background = RBuilder::seniorBackground,
                highlights = RBuilder::seniorHighlights,
                images = seniorImages,
                github = "https://github.com/wylieallen/SeniorProject")
)

interface ProjectsState : RState {
    var selectedProject: Project?
    var dialogOpen: Boolean
}

class Projects : RComponent<RProps, ProjectsState>() {
    init {
        state.selectedProject = null
        state.dialogOpen = false
    }

    private fun closeDialog(event: dynamic, type: String) {
        setState { dialogOpen = false }
    }

    private fun clearSelectedDialog(event: dynamic, type: String) {
        setState { selectedProject = null }
    }

    private fun openDialog(project: Project) {
        setState { selectedProject = project; dialogOpen = true }
    }

    override fun RBuilder.render() {
        div("page") {
            val selectedProject = state.selectedProject

            if(selectedProject != null) {
                projectModal(open = state.dialogOpen, onClose = ::closeDialog, onExited = ::clearSelectedDialog, project = selectedProject)
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
                        attrs { item = true; container = true; xs = 12; md = 11; lg = 10; spacing = 40;}
                        projects.map {
                            Grid {
                                attrs { item = true; xs = 12; md = 6; lg = 3}
                                projectCard(imageSrc = it.images[0], title = it.name, summary = it.tagline, onClick = { openDialog(it) })
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

private class ProjectModal : RComponent<ProjectModalProps, RState>() {
    private val slider = createRef<Slick>()
    private var currentSlideIndex = 0

    override fun componentDidUpdate(prevProps: ProjectModalProps, prevState: RState, snapshot: Any) {
        slider.current?.slickGoTo(currentSlideIndex)
    }

    override fun RBuilder.render() {
        val paperProps = asDynamic()
        paperProps.className = "project-modal-paper"

        val project = props.project
        val onClose = props.onClose

        Dialog {
            attrs {
                this.open = props.open
                this.onClose = props.onClose
                this.onExited = props.onExited
                PaperProps = paperProps
                scroll = "body"
                maxWidth = "md"
            }
            DialogContent {
                div("project-modal") {

                    val closeButtonStyle = asDynamic()
                    closeButtonStyle.color = "white"
                    closeButtonStyle.position = "absolute"
                    closeButtonStyle.top = "4px"
                    closeButtonStyle.right = "4px"

                    IconButton {
                        attrs { onClick = {onClose(null, "")}; style = closeButtonStyle }
                        Close {}
                    }

                    h1 {
                        +project.name
                    }

                    project.description(this)

                    div("project-modal-slider") {
                        Slider {
                            attrs {
                                centerMode = true
                                ref = slider
                                afterChange = { _, after -> currentSlideIndex = after; }
                                initialSlide = currentSlideIndex
                                arrows = false
                                infinite = true
                                dots = true
                            }
                            project.images.map {
                                img(classes = "project-image-slide", src = it) {}
                            }
                        }
                    }

                    h4 {
                        +"Background"
                    }

                    project.background(this)

                    h4 {
                        +"Technical Highlights"
                    }

                    project.highlights(this)

                    div("project-modal-buttons") {
                        if(project.demo != null) {
                            Tooltip {
                                attrs { title = project.demo.tooltip }
                                Button {
                                    attrs {color = "primary"; variant = "contained"; href = project.demo.url; target = "_blank" }
                                    +"Try the demo"
                                    div("fas ${if(project.demo.inBrowser) "fa-external-link-alt" else "fa-download"} project-modal-button-icon") {}
                                }
                            }
                        }

                        Button {
                            attrs {color = "default"; variant = "contained"; href = project.github; target = "_blank" }
                            +"See the code"
                            div ("fab fa-github project-modal-button-icon") {}
                        }
                    }
                }
            }

        }
    }
}

interface ProjectModalProps : RProps {
    var open: Boolean
    var onClose: (dynamic, String) -> Unit
    var onExited: (dynamic, String) -> Unit
    var project: Project
}

private fun RBuilder.projectModal(open: Boolean, onClose: (dynamic, String) -> Unit, onExited: (dynamic, String) -> Unit, project: Project) = child (ProjectModal::class) {
    attrs.open = open
    attrs.onClose = onClose
    attrs.onExited = onExited
    attrs.project = project
}

private fun RBuilder.projectCard(imageSrc: dynamic, title: String, summary: (RBuilder) -> Unit, onClick: () -> Unit) {
    Card {
        attrs { className = "project-card" }
        CardActionArea {
            val style = asDynamic()
            style.padding = "24px"
            style.height = "100%"
            attrs { this.onClick = onClick; this.style = style }
            CardContent {
                h1("project-title") {
                    +title
                }
            }
            CardMedia {
                attrs { image = imageSrc; className = "project-card-media" }
            }
            CardContent {
                attrs { className = "project-card-content" }
                p {
                    summary(this)
                }
            }
        }
    }
}