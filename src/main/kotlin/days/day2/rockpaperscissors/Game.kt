package days.day2.rockpaperscissors

class Game {
    var myScore = 0
        private set
    var opponentScore = 0
        private set

    private companion object {
        const val SCORE_LOSE = 0
        const val SCORE_DRAW = 3
        const val SCORE_WIN = 6
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