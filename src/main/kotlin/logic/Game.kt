package logic

import kotlin.random.Random

fun generateRandomGameField(size: Int, colorsCount: Int): Array<IntArray> {
    return Array(size) {
        IntArray(size) {
            Random.nextInt(colorsCount)
        }
    }
}

fun recolorField(field: Array<IntArray>, newColor: Int): Array<IntArray> {
    val newField = field.deepCopyOf()
    val oldColor = newField[0][0]

    newField.recolorField(newColor, oldColor, 0, 0)

    return newField
}

private fun Array<IntArray>.deepCopyOf(): Array<IntArray> {
    return Array(this.size) { i ->
        this[i].copyOf()
    }
}

fun Array<IntArray>.recolorField(newColor: Int, oldColor: Int, i: Int, j: Int) {
    if (i < 0 || j < 0 || i >= this.size ||j >= this[i].size) {
        return
    }

    if (this[i][j] != oldColor) {
        return
    }

    this[i][j] = newColor

    this.recolorField(newColor, oldColor, i - 1, j)
    this.recolorField(newColor, oldColor, i + 1, j)
    this.recolorField(newColor, oldColor, i, j - 1)
    this.recolorField(newColor, oldColor, i, j + 1)
}

fun isWon(field: Array<IntArray>): Boolean {
    field.forEach { row ->
        row.forEach { item ->
            if (item != field[0][0]) {
                return false
            }
        }
    }

    return true
}