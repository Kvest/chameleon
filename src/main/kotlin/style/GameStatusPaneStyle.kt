package style

import kotlinx.css.*
import styled.*

object GameStatusPaneStyle : StyleSheet("GameStatusPaneStyle", isStatic = true) {
    val newGameButton by css {
        marginTop = 15.px
        marginBottom = 15.px
        cursor = Cursor.pointer
    }
}