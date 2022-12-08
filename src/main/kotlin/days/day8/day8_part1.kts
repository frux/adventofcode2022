import answer.Answer
import input.InputReader

val input = InputReader(day = 8, part = 1).getLines()
val forest = input.map { it.toList() }
val forestHeight = forest.size
val forestWidth = forest[0].size
val visible = Array(forestHeight){ BooleanArray(forestWidth){ false} }

// look from the North
for (col in 0 until forestWidth) {
    var highestTree = forest[0][col].toString().toInt()
    visible[0][col] = true

    for (row in 1 until forestHeight) {
        val height = forest[row][col].toString().toInt()
        val isVisibleFromNorth = height > highestTree

        visible[row][col] = visible[row][col] || isVisibleFromNorth

        if (isVisibleFromNorth) {
            highestTree = height
        }
    }
}

// look from the South
for (col in 0 until forestWidth) {
    var highestTree = forest[forestHeight - 1][col].toString().toInt()
    visible[forestHeight - 1][col] = true

    for (row in forestHeight - 2 downTo 0) {
        val height = forest[row][col].toString().toInt()
        val isVisibleFromSouth = height > highestTree

        visible[row][col] = visible[row][col] || isVisibleFromSouth

        if (isVisibleFromSouth) {
            highestTree = height
        }
    }
}

// look from the East
for (row in 0 until forestHeight) {
    var highestTree = forest[row][forestWidth - 1].toString().toInt()
    visible[row][forestWidth - 1] = true

    for (col in forestWidth - 2 downTo 0) {
        val height = forest[row][col].toString().toInt()
        val isVisibleFromEast = height > highestTree

        visible[row][col] = visible[row][col] || isVisibleFromEast

        if (isVisibleFromEast) {
            highestTree = height
        }
    }
}

// look from the West
for (row in 0 until forestHeight) {
    var highestTree = forest[row][0].toString().toInt()
    visible[row][0] = true

    for (col in 1 until forestWidth) {
        val height = forest[row][col].toString().toInt()
        val isVisibleFromWest = height > highestTree

        visible[row][col] = visible[row][col] || isVisibleFromWest

        if (isVisibleFromWest) {
            highestTree = height
        }
    }
}

Answer(visible.fold(0){acc, row -> acc + row.count{ it }})
