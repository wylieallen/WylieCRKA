package display

import display.displayables.Displayable
import kotlinx.html.id
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import react.*
import react.dom.canvas

interface DisplayCanvasProps : RProps {
    var width: Int
    var height: Int
    var id: String
    var displayable: Displayable
}

class DisplayCanvas(props: DisplayCanvasProps) : RComponent<DisplayCanvasProps, RState>(props) {
    private val canvas: RReadableRef<HTMLCanvasElement> = createRef()
    private val root = props.displayable

    override fun RBuilder.render() {
        canvas("App-canvas") {
            attrs.id = props.id
            attrs.width = props.width.toString()
            attrs.height = props.height.toString()
            ref = canvas
        }
    }

    fun paint() {
        val ctx = canvas.current?.getContext("2d") as CanvasRenderingContext2D
        root.display(CanvasPainter(ctx))
    }
}

fun RBuilder.displayCanvas(width: Int, height: Int, id: String, displayable: Displayable, displayCanvasRef: RReadableRef<DisplayCanvas>) = child(DisplayCanvas::class) {
    attrs.width = width
    attrs.height = height
    attrs.id = id
    attrs.displayable = displayable
    ref = displayCanvasRef
}