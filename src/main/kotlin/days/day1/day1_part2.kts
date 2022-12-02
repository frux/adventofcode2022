import answer.Answer
import input.InputReader

val input = InputReader(day = 1, part = 2).getLines()
var top1 = 0
var top2 = 0
var top3 = 0
var currentCallories = 0

for ((i, line) in input.withIndex()) {
    if (line != "") {
        currentCallories += line.toInt()
    }

    if (line != "" && i + 1 != input.size) {
        continue
    }

    if (currentCallories > top3) {
        top3 = currentCallories
    }

    if (top3 > top2) {
        val tmp = top2;
        top2 = top3
        top3 = tmp
    }

    if (top2 > top1) {
        val tmp = top1;
        top1 = top2
        top2 = tmp
    }

    currentCallories = 0
}

Answer(top1 + top2 + top3)