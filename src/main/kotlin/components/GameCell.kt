package components

import kotlinx.css.*
import react.*
import styled.*

external interface GameCellProps : RProps {
    var color: String
}

val GAME_CELL = rFunction<GameCellProps>("game_cell") { props ->
    styledDiv {
        css {
            css {
                background = props.color
                width = 30.px
                height = 30.px
            }
        }
    }
}

fun RBuilder.gameCell(color: String) = GAME_CELL.invoke {
    attrs.color = color
}