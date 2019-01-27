package display.displayables.primitives

import display.Color
import display.Painter
import display.displayables.AbstractDisplayable

class StringDisplayable(private val stringGenerator: () -> String,
                        private val typeface: String,
                        private val fontSize: Int,
                        private val fontColor: Color) : AbstractDisplayable() {
    override fun doDisplay(p: Painter) {
        p.setColor(fontColor)
        p.setFont(typeface, fontSize)
        p.drawString(stringGenerator())
    }
}