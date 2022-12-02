import answer.Answer
import input.InputReader

val input = InputReader(day = 1, part = 1).getLines()
var maxCallories = 0
var currentCallories = 0

for ((index, line) in input.withIndex()) {
    if (line != "") {
        currentCallories += line.toInt()
    }

    if (line != "" && index + 1 != input.size) {
        continue
    }

    if (currentCallories > maxCallories) {
        maxCallories = currentCallories
    }

    currentCallories = 0
}

Answer(maxCallories)