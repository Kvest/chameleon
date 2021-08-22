package components

import kotlinx.css.*
import react.*
import styled.*

const val GAME_CELL_SIZE = 30

external interface GameCellProps : RProps {
    var color: String
}

val GAME_CELL = rFunction<GameCellProps>("game_cell") { props ->
    styledDiv {
        css {
            css {
                background = props.color
                width = GAME_CELL_SIZE.px
                height = GAME_CELL_SIZE.px
            }
        }
    }
}

fun RBuilder.gameCell(color: String) = GAME_CELL.invoke {
    attrs.color = color
}