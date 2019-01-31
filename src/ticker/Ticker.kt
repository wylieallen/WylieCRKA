package ticker

import external.materialui.Button
import react.*
import react.dom.*
import react.router.dom.routeLink
import kotlin.browser.*

interface TickerProps : RProps {
    var startFrom: Int
}

interface TickerState : RState {
    var secondsElapsed: Int
}

class Ticker(props: TickerProps) : RComponent<TickerProps, TickerState>(props) {
    override fun TickerState.init(props: TickerProps) {
        secondsElapsed = props.startFrom
    }

    var timerID: Int? = null

    override fun componentDidMount() {
        timerID = window.setInterval({
            // actually, the operation is performed on a state's copy, so it stays effectively immutable
            setState { secondsElapsed += 1 }
        }, 1000)
    }

    override fun componentWillUnmount() {
        window.clearInterval(timerID!!)
    }

    override fun RBuilder.render() {
        +"This app has been running for ${state.secondsElapsed} seconds."
        routeLink(to = "/"){
            Button {
                attrs { color = "default"; variant = "contained"; }
                +"Home"
            }
        }
    }
}

fun RBuilder.ticker(startFrom: Int = 0) = child(Ticker::class) {
    attrs.startFrom = startFrom
}
