package display.displayables.composites

import display.Painter
import display.displayables.Displayable
import display.displayables.AbstractDisplayable

class CompositeDisplayable(vararg children: Displayable) : AbstractDisplayable() {
    private val children = linkedSetOf(*children)
    val size : Int
        get() = children.size

    override fun doDisplay(p: Painter) = children.forEach { d -> d.display(p) }

    fun add(displayable: Displayable) = children.add(displayable)
    fun remove(displayable: Displayable) = children.remove(displayable)
}