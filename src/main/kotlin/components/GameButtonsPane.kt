package components

import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import style.GameButtonStyles
import styled.*

external interface GameButtonsPaneProps : RProps {
    var colors: List<String>
    var onChangeColor: (Int) -> Unit
}

val GAME_BUTTONS_PANE = rFunction<GameButtonsPaneProps>("game_buttons_pane") { props ->
    styledDiv {
        css {
            +GameButtonStyles.pane
            display = Display.flex
            justifyContent = JustifyContent.spaceBetween
        }
        props.colors.mapIndexed { index, color ->
            styledButton {
                css {
                    background = color
                    +GameButtonStyles.button
                }
                attrs {
                    onClickFunction = {
                        props.onChangeColor(index)
                    }
                }
            }
        }
    }
}

fun RBuilder.gameButtonsPane(colors: List<String>, onChangeColor: (Int) -> Unit) = GAME_BUTTONS_PANE.invoke {
    attrs.colors = colors
    attrs.onChangeColor = onChangeColor
}