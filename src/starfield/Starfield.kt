package starfield

import display.Color
import display.DisplayCanvas
import display.Painter
import display.displayCanvas
import display.displayables.Displayable
import display.displayables.composites.CompositeDisplayable
import display.displayables.decorators.TranslatedDisplayable
import display.displayables.primitives.SolidRect
import display.tickables.Tickable
import display.tickables.composites.CompositeTickable
import org.w3c.dom.events.Event
import react.*
import kotlin.browser.window
import kotlin.random.Random

interface StarfieldProps : RProps {
    var stars: Int
}

interface StarfieldState : RState {
    var width: Int
    var height: Int
    var repopulateNext: Boolean
}

class Starfield(props: StarfieldProps) : RComponent<StarfieldProps, StarfieldState>(props) {
    private val displayables = CompositeDisplayable()
    private val tickables = CompositeTickable()
    private val canvas = createRef<DisplayCanvas>()

    init {
        state.width = window.innerWidth
        state.height = window.innerHeight
        state.repopulateNext = true;

        window.addEventListener("resize", this::resize)

        tick(window.performance.now())
    }

    override fun componentWillUnmount() {
        window.removeEventListener("resize", this::resize)
    }

    fun resize(e: Event) {
        setState { width = window.innerWidth; height = window.innerHeight; repopulateNext = true; }
    }

    private fun populateStars() {
        displayables.clear()
        tickables.clear()

        displayables.add(SolidRect(state.width.toDouble(), state.height.toDouble(), Color.BLACK))

        val layers = 3
        val starsPerLayer = props.stars / layers

        for(i in 1..layers) {
            val topLayer = StarLayer(0.0, -state.height.toDouble(), i, starsPerLayer)
            val bottomLayer = StarLayer(0.0, 0.0, i, starsPerLayer)
            displayables.add(topLayer)
            displayables.add(bottomLayer)
            tickables.add(topLayer)
            tickables.add(bottomLayer)
        }

    }

    override fun RBuilder.render() {
        if(state.repopulateNext) {
            setState { repopulateNext = false }
            populateStars()
        }
        displayCanvas(state.width, state.height, "starfield-canvas", displayables, canvas)
    }

    fun tick(timestamp: Double) {
        update()
        repaint()
        window.requestAnimationFrame(this::tick)
    }

    private fun update() { this.tickables.tick() }
    private fun repaint() { canvas.current?.paint() }

    private inner class StarLayer(x: Double, y: Double, private val dy: Int, starCount: Int) : Displayable, Tickable {
        private val displayable: TranslatedDisplayable

        init {
            val composite = CompositeDisplayable()
            displayable = TranslatedDisplayable(x, y, composite)

            val size = 1.0 + Random.nextInt(3)
            for(i in 1..starCount) {
                composite.add(makeStar(size))
            }
        }

        override fun display(painter: Painter) = displayable.display(painter)

        override fun tick() {
            displayable.y += dy
            if(displayable.y >= state.height) {
                displayable.y = -state.height.toDouble()
            }
        }

        private fun makeStar(size: Double) : Displayable {
            return TranslatedDisplayable(Random.nextInt(state.width).toDouble(), Random.nextInt(state.height).toDouble(),
                    SolidRect(size, size, Color(Random.nextInt(0xFF), Random.nextInt(0xFF), Random.nextInt(0xFF)))
            )
        }
    }
}

fun RBuilder.starfield(stars: Int) = child(Starfield::class) {
    attrs.stars = stars
}