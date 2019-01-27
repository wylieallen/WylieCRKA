package display.displayables.primitives

import display.Painter
import display.displayables.Displayable

class NullDisplayable private constructor() : Displayable {
    override fun display(p: Painter) {}

    companion object {
        val INSTANCE = NullDisplayable()
    }
}