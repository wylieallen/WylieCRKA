package display.displayables

import display.Painter

abstract class AbstractDisplayable : Displayable {
    override fun display(p: Painter) {
        p.push()
        doDisplay(p)
        p.pop()
    }

    protected abstract fun doDisplay(p: Painter)
}