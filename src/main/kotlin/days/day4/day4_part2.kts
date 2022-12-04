import answer.Answer
import input.InputReader

val input = InputReader(day = 4, part = 2).getLines()
var overlapsCounter = 0

for (line in input) {
    val (range1, range2) = line.split(',')
    val (from1, to1) = range1.split('-').map { it.toInt() }
    val (from2, to2) = range2.split('-').map { it.toInt() }

    if (
        from2 in from1 .. to1 ||
        to2 in from1..to1 ||
        from1 in from2..to2 ||
        to1 in from2..to2
    ) {
        overlapsCounter += 1
    }
}

Answer(overlapsCounter)