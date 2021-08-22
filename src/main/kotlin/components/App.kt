package components

import react.*

private val COLORS = listOf("Red", "Gold", "LawnGreen", "SaddleBrown", "Magenta", "Navy")
private const val FIELD_SIZE = 14
private const val MOVES_COUNT = 21

@JsExport
class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        chameleonGame {
            colors = COLORS
            fieldSize = FIELD_SIZE
            movesCount = MOVES_COUNT
        }
    }
}