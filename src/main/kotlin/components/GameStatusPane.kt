package components

import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import style.GameStatusPaneStyle
import styled.*

external interface GameStatusPaneProps : RProps {
    var movesLeft: Int
    var totalMoves: Int
    var onNewGame: (Event) -> Unit
}

val GAME_STATUS_PANE = rFunction<GameStatusPaneProps>("game_status_pane") { props ->
    styledDiv {
        css {
            display = Display.flex
            justifyContent = JustifyContent.spaceBetween
        }
        h2 {
            +"Left ${props.movesLeft} of ${props.totalMoves} moves"
        }

        styledButton {
            css {
                +GameStatusPaneStyle.newGameButton
            }
            attrs {
                onClickFunction = props.onNewGame
            }
            +"New game"
        }
    }
}

fun RBuilder.gameStatusPane(movesLeft: Int, totalMoves: Int, onNewGame: (Event) -> Unit) = GAME_STATUS_PANE.invoke {
    attrs.movesLeft = movesLeft
    attrs.totalMoves = totalMoves
    attrs.onNewGame = onNewGame
}