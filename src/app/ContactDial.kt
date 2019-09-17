package app

import external.materialui.SpeedDial
import external.materialui.SpeedDialAction
import external.materialui.SpeedDialIcon
import external.materialui.icons.Contacts
import external.materialui.icons.Message
import react.*
import react.dom.div

fun RBuilder.contactDial(open: Boolean, onClick: (dynamic, String) -> Unit) {
    val dialStyle = asDynamic()
    dialStyle.position = "absolute"
    dialStyle.bottom = "32px"
    dialStyle.right = "32px"
    SpeedDial {
        attrs {
            ariaLabel = "Contact Me"
            direction = "up"
            icon = SpeedDialIcon{ attrs { icon = Message{}; openIcon = Contacts{} } }
            this.open = open
            this.onClick = onClick
            style = dialStyle
        }
        SpeedDialAction{
            attrs {
                icon = div("fab fa-2x fa-github"){}
                href = "https://www.github.com/wylieallen/"
                target = "_blank"
                tooltipTitle = "GitHub"
            }
        }
        SpeedDialAction{
            attrs {
                icon = div("fab fa-2x fa-linkedin"){}
                href = "https://www.linkedin.com/in/wylieallen/"
                target = "_blank"
                tooltipTitle = "LinkedIn"
            }
        }
        SpeedDialAction{
            attrs {
                icon = div("fas fa-2x fa-envelope"){}
                href = "mailto:contact@wylieallen.dev"
                tooltipTitle = "Email"
            }
        }
    }
}