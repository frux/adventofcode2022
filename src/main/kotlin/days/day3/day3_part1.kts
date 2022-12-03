import answer.Answer
import days.day3.Rucksack
import input.InputReader

val input = InputReader(day = 3, part = 1).getLines()
var totalPriority = 0

for (line in input) {
    val rucksack = Rucksack(line)
    totalPriority += rucksack.getRearrangementPriority()
}

Answer(totalPriority)