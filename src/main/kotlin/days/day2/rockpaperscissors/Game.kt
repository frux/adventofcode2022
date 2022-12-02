package days.day2.rockpaperscissors

class Game {
    var myScore = 0
        private set
    var opponentScore = 0
        private set

    companion object {
        private const val SCORE_LOSE = 0
        private const val SCORE_DRAW = 3
        private const val SCORE_WIN = 6

        private const val RESULT_LOSE = "X"
        private const val RESULT_DRAW = "Y"
        private const val RESULT_WIN = "Z"

        fun getShapeByResult(opponent: Shape, result: String): Shape {
            if (result == RESULT_DRAW) {
                return opponent
            }

            return when (opponent.type) {
                ShapeType.ROCK -> if (result == RESULT_WIN) Shape(ShapeType.PAPER) else Shape(ShapeType.SCISSORS)
                ShapeType.PAPER -> if (result == RESULT_WIN) Shape(ShapeType.SCISSORS) else Shape(ShapeType.ROCK)
                ShapeType.SCISSORS -> if (result == RESULT_WIN) Shape(ShapeType.ROCK) else Shape(ShapeType.PAPER)
            }
        }
    }

    fun makeTurn(opponent: Shape, me: Shape) {
        when {
            me < opponent -> {
                myScore += SCORE_LOSE
                opponentScore += SCORE_WIN
            }
            me > opponent -> {
                myScore += SCORE_WIN
                opponentScore += SCORE_LOSE
            }
            else -> {
                myScore += SCORE_DRAW
                opponentScore += SCORE_DRAW
            }
        }

        myScore += me.getScore()
        opponentScore += opponent.getScore()
    }
}