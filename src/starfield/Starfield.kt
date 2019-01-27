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
import react.*
import kotlin.browser.window
import kotlin.random.Random

interface StarfieldProps : RProps {
    var width: Int
    var height: Int
    var stars: Int
}

class Starfield(props: StarfieldProps) : RComponent<StarfieldProps, RState>(props) {
    private val displayables = CompositeDisplayable()
    private val tickables = CompositeTickable()
    private val canvas = createRef<DisplayCanvas>()

    init {
        displayables.add(SolidRect(props.width.toDouble(), props.height.toDouble(), Color.BLACK))

        for(i in 1..props.stars) {
            val star = Star(Random.nextDouble() * props.width, Random.nextDouble() * props.height, Random.nextInt(3).toDouble() + 1, Color.random())
            displayables.add(star)
            tickables.add(star)
        }

        // todo: add resize event listener

        tick(window.performance.now())
    }

    override fun componentWillUnmount() {
        // todo: remove event listeners
    }

    override fun RBuilder.render() {
        displayCanvas(props.width, props.height, "starfield-canvas", displayables, canvas)
    }

    fun tick(timestamp: Double) {
        update()
        repaint()
        window.requestAnimationFrame(this::tick)
    }

    private fun update() = tickables.tick()
    private fun repaint() { canvas.current?.paint() }

    private inner class Star(x: Double, var y: Double, val dy: Double, color: Color) : Displayable, Tickable {
        private val displayable = TranslatedDisplayable(x, y, SolidRect(1.0, 1.0, color))

        override fun display(painter: Painter) = displayable.display(painter)
        override fun tick() {
            this.y += dy
            if(this.y > props.height) {
                this.y = 0.0
            }
            displayable.y = y
        }
    }
}

fun RBuilder.starfield(width: Int, height: Int, stars: Int) = child(Starfield::class) {
    attrs.width = width
    attrs.height = height
    attrs.stars = stars
}