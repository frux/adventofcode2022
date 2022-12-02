package days.day2.rockpaperscissors

enum class ShapeType(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}

class Shape(val type: ShapeType) {
    constructor(code: String): this(when (code) {
        "A", "X" -> ShapeType.ROCK
        "B", "Y" -> ShapeType.PAPER
        "C", "Z" -> ShapeType.SCISSORS
        else -> throw Error("Unknown shape code $code")
    })

    fun getScore() = type.score

    override operator fun equals(other: Any?): Boolean {
        if (other !is Shape) {
            return false
        }

        return other.type == this.type
    }

    operator fun compareTo(other: Any?): Int {
        if (other !is Shape) {
            return 0
        }

        if (this.type == other.type) {
            return 0
        }

        if (
            (this.type == ShapeType.ROCK && other.type == ShapeType.SCISSORS) ||
            (this.type == ShapeType.PAPER && other.type == ShapeType.ROCK) ||
            (this.type == ShapeType.SCISSORS && other.type == ShapeType.PAPER)
        ) {
            return 1
        }

        return -1
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }
}