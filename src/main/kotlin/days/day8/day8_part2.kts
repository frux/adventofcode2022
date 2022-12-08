import answer.Answer
import input.InputReader

val input = InputReader(day = 8, part = 2).getLines()
val forest = input.map { it.toList() }

fun lookSouth(forest: List<List<Char>>, row: Int, col: Int): Int {
    val height = forest[row][col].toString().toInt()
    var distance = 0
    for (i in row + 1 until forest.size) {
        distance += 1
        if (forest[i][col].toString().toInt() >= height) {
            break
        }
    }

    return distance
}

fun lookNorth(forest: List<List<Char>>, row: Int, col: Int): Int {
    val height = forest[row][col].toString().toInt()
    var distance = 0
    for (i in row - 1 downTo 0) {
        distance += 1
        if (forest[i][col].toString().toInt() >= height) {
            break
        }
    }

    return distance
}

fun lookEast(forest: List<List<Char>>, row: Int, col: Int): Int {
    val height = forest[row][col].toString().toInt()
    var distance = 0
    for (i in col + 1 until forest[0].size) {
        distance += 1
        if (forest[row][i].toString().toInt() >= height) {
            break
        }
    }

    return distance
}

fun lookWest(forest: List<List<Char>>, row: Int, col: Int): Int {
    val height = forest[row][col].toString().toInt()
    var distance = 0
    for (i in col - 1 downTo 0) {
        distance += 1
        if (forest[row][i].toString().toInt() >= height) {
            break
        }
    }

    return distance
}

var maxScenicScore = 0

for (row in 1 until forest.size - 1) {
    for (col in 1 until forest[0].size - 1) {
        val scenicScore = lookNorth(forest, row, col) *
                lookEast(forest, row, col) *
                lookSouth(forest, row, col) *
                lookWest(forest, row, col)

        if (scenicScore > maxScenicScore) {
            maxScenicScore = scenicScore
        }
    }
}

Answer(maxScenicScore)
