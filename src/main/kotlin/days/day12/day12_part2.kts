import answer.Answer
import input.InputReader

val input = InputReader(day = 12, part = 2).getCharMatrix()
var end = findAll(input, 'E')[0]

fun findShortestPathLength(start: Pair<Int, Int>): Int? {
    val costMap = Array(input.size) { arrayOfNulls<Int>(input[0].size) }

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

    return costMap[end.first][end.second]
}

var shortestPathLength = Int.MAX_VALUE
var starts = findAll(input, 'a') + findAll(input, 'S')

println(starts)

for (start in starts) {
    val length = findShortestPathLength(start)

    if (length != null && length < shortestPathLength) {
        shortestPathLength = length
    }
}

Answer(shortestPathLength)

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

fun findAll(map: List<List<Char>>, subject: Char): List<Pair<Int, Int>> {
    val found = mutableListOf<Pair<Int, Int>>()

    for (row in map.indices) {
        for (col in map[row].indices) {
            if (map[row][col] == subject)  {
                found.add(Pair(row, col))
            }
        }
    }

    return found
}