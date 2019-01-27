package display.displayables.decorators

import display.Painter
import display.displayables.AbstractDisplayable
import display.displayables.Displayable
import kotlin.math.PI


class RotatedDisplayable(private val target: Displayable,
                         private val centerX: Double,
                         private val centerY: Double,
                         private var theta: Double) : AbstractDisplayable() {

    companion object {
        const val TWO_PI = PI * 2
        const val NEGATIVE_TWO_PI = -TWO_PI
    }

    override fun doDisplay(p: Painter) {
        p.translate(centerX, centerY)
        p.rotate(theta)
        p.translate(-centerX, -centerY)
        target.display(p)
    }

    fun rotate(radians: Double) {
        theta += radians
        if(theta > TWO_PI || theta < NEGATIVE_TWO_PI) {
            theta %= TWO_PI
        }
    }
}