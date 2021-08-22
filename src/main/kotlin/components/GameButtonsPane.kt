package components

import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import styled.*

external interface GameButtonsPaneProps : RProps {
    var colors: List<String>
    var onChangeColor: (Int) -> Unit
}

val GAME_BUTTONS_PANE = rFunction<GameButtonsPaneProps>("game_buttons_pane") { props ->
    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.row
        }
        props.colors.mapIndexed { index, color ->
            styledButton {
                css {
                    background = color
                    width = 50.px
                    height = 50.px
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