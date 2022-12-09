import answer.Answer
import days.day9.Rope
import input.InputReader

val input = InputReader(day = 9, part = 1).getLines()
val rope = Rope()

for (line in input) {
    val (direction, distance) = line.split(" ")

    rope.moveHead(direction[0], distance.toInt())
}

Answer(rope.getUniqueVisitedPositionsNumber())
