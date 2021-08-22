package style

import kotlinx.css.*
import styled.*

object GameStatusPaneStyles : StyleSheet("GameStatusPaneStyles", isStatic = true) {
    val newGameButton by css {
        marginTop = 15.px
        marginBottom = 15.px
        cursor = Cursor.pointer
    }
}