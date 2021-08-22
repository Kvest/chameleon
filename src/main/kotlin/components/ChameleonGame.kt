package components

import logic.generateRandomGameField
import logic.isWon
import logic.recolorField
import react.*
import react.dom.div

external interface ChameleonGameProps : RProps {
    var colors: List<String>
    var fieldSize: Int
    var movesCount: Int
}

external interface ChameleonGameState : RState {
    var field: Array<IntArray>
    var movesLeft: Int
    var isGameFinished: Boolean
    var isWon: Boolean
}

fun RBuilder.chameleonGame(handler: ChameleonGameProps.() -> Unit): ReactElement {
    return child(ChameleonGame::class) {
        this.attrs(handler)
    }
}

@JsExport
class ChameleonGame(props: ChameleonGameProps) : RComponent<ChameleonGameProps, ChameleonGameState>(props) {
    override fun ChameleonGameState.init(props: ChameleonGameProps) {
        field = generateRandomGameField(props.fieldSize, props.colors.size)
        movesLeft = props.movesCount
        isGameFinished = false
        isWon = false
    }

    override fun RBuilder.render() {
        div {
            gameField(
                field = state.field,
                colors = props.colors
            )
            gameButtonsPane(
                colors = props.colors,
                onChangeColor = ::onChangeColor
            )
        }
    }
    private fun onChangeColor(newColor: Int) {
        if (state.isGameFinished) {
            return
        }

        val newField = recolorField(state.field, newColor)
        val newMovesLeft = state.movesLeft - 1
        val newIsWon = isWon(newField)
        val newIsGameFinished = newIsWon || newMovesLeft == 0

        setState {
            field = newField
            movesLeft = newMovesLeft
            isGameFinished = newIsGameFinished
            isWon = newIsWon
        }
    }
}
