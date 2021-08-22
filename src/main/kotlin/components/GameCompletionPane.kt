package components

import react.*
import style.GameCompletionPaneStyles
import styled.*

private const val WIN_TEXT = "You win"
private const val LOSE_TEXT = "You lose"

external interface GameCompletionPaneProps : RProps {
    var isWin: Boolean
}

val GAME_COMPLETION_PANE = rFunction<GameCompletionPaneProps>("GameCompletionPane") { props ->
    styledH3 {
        css {
            +GameCompletionPaneStyles.paneText
            +GameCompletionPaneStyles.paneCenterPositioning
        }
        +(if (props.isWin) WIN_TEXT else LOSE_TEXT)
    }
}

fun RBuilder.gameCompletionPane(isWin: Boolean) = GAME_COMPLETION_PANE.invoke {
    attrs.isWin = isWin
}