package days.day9

import kotlin.math.absoluteValue
import kotlin.math.sign

class Rope(val length: Int) {
    private val knots = Array(length){Knot()}
    private val history = mutableSetOf<String>()

    fun getUniqueVisitedPositionsNumber() = history.size

    fun moveHead(direction: Char, distance: Int) {
        for (i in 0 until distance) {
            step(direction)
            history.add("${knots[knots.lastIndex].x},${knots[knots.lastIndex].y}")
        }
    }

    private fun step(direction: Char) {
        when (direction) {
            'U' -> knots[0].y += 1
            'D' -> knots[0].y -= 1
            'R' -> knots[0].x += 1
            'L' -> knots[0].x -= 1
            else -> throw Error("Wrong direction")
        }

        for (i in 1 until knots.size) {
            normalizeKnot(i)
        }
    }

    private fun normalizeKnot(knotIndex: Int) {
        val knot = knots[knotIndex]
        val prevKnot = knots[knotIndex - 1]
        val knotDistanceX = prevKnot.x - knot.x
        val knotDistanceY = prevKnot.y - knot.y

        if (knotDistanceX.absoluteValue > 1) {
            knot.x = prevKnot.x - (1 * knotDistanceX.sign)
            knot.y = prevKnot.y
        }

        if (knotDistanceY.absoluteValue > 1) {
            knot.y = prevKnot.y - (1 * knotDistanceY.sign)
            knot.x = prevKnot.x
        }
    }
}