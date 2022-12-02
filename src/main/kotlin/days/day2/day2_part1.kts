import answer.Answer
import days.day2.rockpaperscissors.Game
import days.day2.rockpaperscissors.Shape
import input.InputReader

val game = Game()
val input = InputReader(day = 2, part = 1).getLines()

for (line in input) {
    val (opponent, me) = line.split(' ')
    game.makeTurn(Shape(opponent), Shape(me))
}

Answer(game.myScore)