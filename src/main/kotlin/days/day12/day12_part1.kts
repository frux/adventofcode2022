import answer.Answer
import input.InputReader

val input = InputReader(day = 12, part = 1).getCharMatrix()
val costMap = Array(input.size) { arrayOfNulls<Int>(input[0].size) }
var start = find(input, 'S')
var end = find(input, 'E')

var nextPointers = mutableListOf(start)

costMap[start.first][start.second] = 0

while (costMap[end.first][end.second] == null && nextPointers.size > 0) {
    val pointers = nextPointers
    nextPointers = mutableListOf()

    for (pointer in pointers) {
        val row = pointer.first
        val col = pointer.second
        val cost = (costMap[row][col] ?: 0) + 1
        if (row > 0 && costMap[row-1][col] == null && isAvailable(input, row, col, row - 1, col)) {
            costMap[row-1][col] = minOf(costMap[row-1][col] ?: Int.MAX_VALUE, cost)
            nextPointers.add(Pair(row-1, col))
        }

        if (row < costMap.size - 1 && costMap[row+1][col] == null && isAvailable(input, row, col, row + 1, col)) {
            costMap[row+1][col] = minOf(costMap[row+1][col] ?: Int.MAX_VALUE, cost)
            nextPointers.add(Pair(row+1, col))
        }

        if (col > 0 && costMap[row][col-1] == null && isAvailable(input, row, col, row, col - 1)) {
            costMap[row][col-1] = minOf(costMap[row][col-1] ?: Int.MAX_VALUE, cost)
            nextPointers.add(Pair(row, col-1))
        }

        if (col < costMap[0].size - 1 && costMap[row][col+1] == null && isAvailable(input, row, col, row, col + 1)) {
            costMap[row][col+1] = minOf(costMap[row][col+1] ?: Int.MAX_VALUE, cost)
            nextPointers.add(Pair(row, col+1))
        }
    }
}

fun isAvailable(map: List<List<Char>>, fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
    return toHeight(map[toX][toY]) - toHeight(map[fromX][fromY]) <= 1
}

fun toHeight(value: Char): Int {
    if (value == 'S') {
        return 'a'.code
    }

    if (value == 'E') {
        return 'z'.code
    }

    return value.code
}

fun find(map: List<List<Char>>, subject: Char): Pair<Int, Int> {
    for (row in map.indices) {
        for (col in map[row].indices) {
            if (map[row][col] == subject)  {
                return Pair(row, col)
            }
        }
    }
    throw Error("Subject not found")
}

Answer(costMap[end.first][end.second] ?: 0)