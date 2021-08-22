package style

import kotlinx.css.*
import styled.*

object GameButtonStyles : StyleSheet("GameButtonStyles", isStatic = true) {
    val pane by css {
        marginTop = 15.px
    }

    val button by css {
        width = 50.px
        height = 50.px
        borderRadius = 50.pct
        border = "none"
        cursor = Cursor.pointer
    }
}