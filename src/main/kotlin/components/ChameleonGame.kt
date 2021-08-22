package components

import kotlinx.css.*
import logic.generateRandomGameField
import logic.isWin
import logic.recolorField
import org.w3c.dom.events.Event
import react.*
import style.GameCompletionPaneStyles
import styled.*

const val GAME_CELL_SIZE = 30

external interface ChameleonGameProps : RProps {
    var colors: List<String>
    var fieldSize: Int
    var movesCount: Int
}

external interface ChameleonGameState : RState {
    var field: Array<IntArray>
    var movesLeft: Int
    var isGameFinished: Boolean
    var isWin: Boolean
}

fun RBuilder.chameleonGame(handler: ChameleonGameProps.() -> Unit): ReactElement {
    return child(ChameleonGame::class) {
        this.attrs(handler)
    }
}

@JsExport
class ChameleonGame(props: ChameleonGameProps) : RComponent<ChameleonGameProps, ChameleonGameState>(props) {
    override fun ChameleonGameState.init(props: ChameleonGameProps) {
        initNewGame(props)
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                maxWidth = (props.fieldSize * GAME_CELL_SIZE).px
            }
            gameStatusPane(
                movesLeft = state.movesLeft,
                totalMoves = props.movesCount,
                onNewGame = ::onNewGame
            )

            styledDiv {
                css {
                    position = Position.relative
                }

                gameField(
                    field = state.field,
                    colors = props.colors
                )

                if (state.isGameFinished) {
                    gameCompletionPane(state.isWin)
                }
            }

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

        //Don't allow to select newColor the same as color of the "start" cell
        if (state.field[0][0] == newColor) {
            return
        }

        val newField = recolorField(state.field, newColor)
        val newMovesLeft = state.movesLeft - 1
        val newIsWin = isWin(newField)
        val newIsGameFinished = newIsWin || newMovesLeft == 0

        setState {
            field = newField
            movesLeft = newMovesLeft
            isGameFinished = newIsGameFinished
            isWin = newIsWin
        }
    }

    private fun onNewGame(event: Event) {
        setState {
            initNewGame(props)
        }
    }

    private fun ChameleonGameState.initNewGame(props: ChameleonGameProps) {
        field = generateRandomGameField(props.fieldSize, props.colors.size)
        movesLeft = props.movesCount
        isGameFinished = false
        isWin = false
    }
}
