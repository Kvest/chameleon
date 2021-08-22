package components

import kotlinx.css.*
import react.*
import styled.*

private val COLORS = listOf("Red", "Gold", "LawnGreen", "SaddleBrown", "Magenta", "Navy")
private const val FIELD_SIZE = 14
private const val MOVES_COUNT = 21

@JsExport
class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                display = Display.flex
            }
            styledDiv {
                css {
                    marginLeft = LinearDimension.auto
                    marginRight = LinearDimension.auto
                    display = Display.inlineBlock
                }
                chameleonGame {
                    colors = COLORS
                    fieldSize = FIELD_SIZE
                    movesCount = MOVES_COUNT
                }
            }
        }
    }
}