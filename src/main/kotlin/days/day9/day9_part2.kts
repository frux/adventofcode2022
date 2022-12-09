import answer.Answer
import days.day9.Rope
import input.InputReader

val input = InputReader(day = 9, part = 2).getLines()
val rope = Rope(length = 10)

for (line in input) {
    val (direction, distance) = line.split(" ")

    rope.moveHead(direction[0], distance.toInt())
}

Answer(rope.getUniqueVisitedPositionsNumber())
