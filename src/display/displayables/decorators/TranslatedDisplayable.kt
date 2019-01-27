package display.displayables.decorators

import display.Painter
import display.displayables.AbstractDisplayable
import display.displayables.Displayable

class TranslatedDisplayable(var x: Double, var y: Double, var target: Displayable) : AbstractDisplayable() {
    override fun doDisplay(p: Painter) {
        p.translate(x, y)
        target.display(p)
    }
}
