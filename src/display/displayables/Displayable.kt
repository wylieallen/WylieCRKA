package display.displayables

import display.Painter

interface Displayable {
    fun display(painter: Painter)
}