package display.tickables.primitives

import display.tickables.Tickable

class SimpleTickable(private val onTick: () -> Unit) : Tickable {
    override fun tick() = onTick()
}