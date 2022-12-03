import answer.Answer
import days.day3.Rucksack
import input.InputReader

val input = InputReader(day = 3, part = 2).getLines()
var totalPriority = 0

for (i in input.indices step 3) {
    totalPriority += Rucksack.getCommonItemPriority(listOf(
        Rucksack(input[i]),
        Rucksack(input[i+1]),
        Rucksack(input[i+2]),
    ))
}

Answer(totalPriority)