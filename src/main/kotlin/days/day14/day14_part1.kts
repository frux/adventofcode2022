import answer.Answer
import days.day14.Sand
import input.InputReader
import kotlin.math.absoluteValue
import kotlin.math.sign

val input = InputReader(day = 14, part = 1).getLines()
val cave = mutableMapOf<Int, MutableMap<Int, Int>>()

val sandStartX = 500
val sandStartY = 0

var xMin = sandStartX
var xMax = sandStartX
val yMin = sandStartY
var yMax = sandStartY

for (line in input) {
    val stops = line.split(" -> ")

    for (i in 0 until stops.lastIndex) {
        val (fromX, fromY) = stops[i].split(",").map{ it.toInt() }
        val (toX, toY) = stops[i + 1].split(",").map{ it.toInt() }

        if (fromX == toX) {
            for (deltaY in 0 .. (toY - fromY).absoluteValue) {
                val y = fromY + deltaY * (toY - fromY).sign

                setRock(fromX, y)
            }
        } else {
            for (deltaX in 0 .. (toX - fromX).absoluteValue) {
                val x = fromX + deltaX * (toX - fromX).sign

                setRock(x, fromY)
            }
        }

        xMin = minOf(xMin, fromX, toX)
        xMax = maxOf(xMax, fromX, toX)
        yMax = maxOf(yMax, fromY, toY)
    }
}

root@ while (true) {
    val sand = Sand()

    while (sand.fall(cave)) {
        if (sand.y > yMax) {
            var count = 0

            for (row in cave.values) {
                for (cell in row.values) {
                    if (cell == 1) {
                        count++
                    }
                }
            }
            Answer(count)
            break@root
        }
    }
    setSand(sand.x, sand.y)
}

fun setRock(x: Int, y: Int) {
    if (cave[x] == null) {
        cave[x] = mutableMapOf()
    }

    cave[x]!![y] = 0
}

fun setSand(x: Int, y: Int) {
    if (cave[x] == null) {
        cave[x] = mutableMapOf()
    }

    cave[x]!![y] = 1
}
