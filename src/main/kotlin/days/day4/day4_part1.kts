import answer.Answer
import input.InputReader

val input = InputReader(day = 4, part = 1).getLines()
var overlapsCounter = 0

for (line in input) {
    val (range1, range2) = line.split(',')
    val (from1, to1) = range1.split('-').map { it.toInt() }
    val (from2, to2) = range2.split('-').map { it.toInt() }

    if (from1 <= from2 && to1 >= to2 || from2 <= from1 && to2 >= to1) {
        overlapsCounter += 1
    }
}

Answer(overlapsCounter)