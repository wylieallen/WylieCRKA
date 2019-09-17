package pages.privacy

import external.materialui.Button
import external.react.router.dom.routeLink
import react.*
import react.dom.a
import react.dom.div
import react.dom.h3
import react.dom.p

class Privacy : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("page") {
            div("page-content") {
                div("privacy-wrapper") {
                    div("privacy-policy") {
                        h3 { +"Privacy Policy" }
                        p {
                            + "I use cookies from Google Analytics to gain insights into user activity on the site."
                            + " Google Analytics collects information such as which pages you visited and how much time you spent on those pages."
                        }
                        p {
                            + "You can read more about Google Analytics on their "
                            a(href = "http://www.google.com/analytics/tos.html", target = "_blank") { +"Terms of Use" }
                            + " and the "
                            a(href = "http://www.google.com/privacypolicy.html", target = "_blank") { + "Google Privacy Policy." }
                            + " If you'd like to opt out of Google Analytics tracking altogether, consider downloading "
                            a(href = "https://tools.google.com/dlpage/gaoptout", target = "_blank") { + "this opt-out plugin by Google" }
                            +", "
                            a(href = "https://www.eff.org/privacybadger", target = "_blank") { + "the Privacy Badger plugin from the EFF" }
                            + ", or disabling cookies in your browser."
                        }
                        routeLink(to = "/") {
                            Button {
                                attrs { color = "default"; variant = "contained"; }
                                +"Home"
                            }
                        }
                    }
                }
            }
        }
    }
}