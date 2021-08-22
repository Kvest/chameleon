package style

import kotlinx.css.*
import kotlinx.css.properties.transform
import kotlinx.css.properties.translate
import styled.*

object GameCompletionPaneStyles : StyleSheet("GameCompletionPaneStyles", isStatic = true) {
    val paneText by css {
        border = BorderStyle.solid.name
        borderWidth = 3.px
        borderRadius = 8.px
        borderColor = Color.blue
        color = Color.blue
        fontSize = 32.px
        padding(30.px)
        display = Display.inlineBlock
        background = Color.white.value
        margin(0.px)
    }

    val paneCenterPositioning by css {
        position = Position.absolute
        top = 50.pct
        left = 50.pct
        transform {
            translate((-50).pct, (-50).pct)
        }
    }
}