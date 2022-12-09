package days.day9

class Rope {
    private var headX = 0
    private var headY = 0
    private var tailX = 0
    private var tailY = 0
    private val history = mutableSetOf<String>()

    companion object {
        const val ROPE_LENGTH = 1
    }

    fun getUniqueVisitedPositionsNumber() = history.size

    fun moveHead(direction: Char, distance: Int) {
        for (i in 0 until distance) {
            step(direction)
            history.add("$tailX,$tailY")
        }
    }

    private fun step(direction: Char) {
        when (direction) {
            'U' -> {
                headY += 1
                if (headY - tailY > ROPE_LENGTH) {
                    tailX = headX
                }
                if (headY - tailY > ROPE_LENGTH) {
                    tailY = headY - ROPE_LENGTH
                }
            }
            'D' -> {
                headY -= 1
                if (tailY - headY > ROPE_LENGTH) {
                    tailX = headX
                }
                if (tailY - headY > ROPE_LENGTH) {
                    tailY = headY + ROPE_LENGTH
                }
            }
            'R' -> {
                headX += 1
                if (headX - tailX > ROPE_LENGTH) {
                    tailY = headY
                }
                if (headX - tailX > ROPE_LENGTH) {
                    tailX = headX - ROPE_LENGTH
                }
            }
            'L' -> {
                headX -= 1
                if (tailX - headX > ROPE_LENGTH) {
                    tailY = headY
                }
                if (tailX - headX > ROPE_LENGTH) {
                    tailX = headX + ROPE_LENGTH
                }
            }
            else -> throw Error("Wrong direction")
        }
    }
}