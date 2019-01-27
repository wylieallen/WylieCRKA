package display.tickables.primitives

import display.tickables.Tickable

class NullTickable private constructor() : Tickable {
    override fun tick() {}
    companion object {
        val instance = NullTickable()
    }
}