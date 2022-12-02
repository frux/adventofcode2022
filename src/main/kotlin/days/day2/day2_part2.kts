import answer.Answer
import days.day2.rockpaperscissors.Game
import days.day2.rockpaperscissors.Shape
import input.InputReader

val game = Game()
val input = InputReader(day = 2, part = 2).getLines()

for (line in input) {
    val (opponent, result) = line.split(' ')
    val opponentShape = Shape(opponent)
    val myShape = Game.getShapeByResult(opponentShape, result)
    game.makeTurn(opponentShape, myShape)
}

Answer(game.myScore)