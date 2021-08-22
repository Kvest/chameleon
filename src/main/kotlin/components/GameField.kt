package components

import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.display
import kotlinx.css.flexDirection
import react.*
import styled.css
import styled.styledDiv

external interface GameFieldProps : RProps {
    var field: List<List<Int>>
    var colors: List<String>
}

val GAME_FIELD = rFunction<GameFieldProps>("game_field") { props ->
    props.field.map { row ->
        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
            }
            row.map { colorIndex ->
                gameCell(props.colors[colorIndex])
            }
        }
    }
}

fun RBuilder.gameField(field: List<List<Int>>, colors: List<String>) = GAME_FIELD.invoke {
    attrs.field = field
    attrs.colors = colors
}