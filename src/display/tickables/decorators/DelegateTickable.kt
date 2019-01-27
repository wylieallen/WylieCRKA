package display.tickables.decorators

import display.tickables.Tickable
import display.tickables.primitives.NullTickable

class DelegateTickable(var delegate: Tickable = NullTickable.instance) : Tickable {
    override fun tick() = delegate.tick()
}