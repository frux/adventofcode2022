import answer.Answer
import days.day11.Item
import days.day11.Monkey
import days.day11.Operation
import input.InputReader

val input = InputReader(day = 11, part = 1).getLines()
val monkeys = mutableListOf<Monkey>()

for (i in input.indices step 7) {
    val itemsInput = input[i + 1].substring(18).split(", ")
    val operationInput = input[i + 2].substring(19).split(" ")
    val testFactorInput = input[i + 3].substring(21)
    val truthyMonkeyInput = input[i + 4].substring(29)
    val falsyMonkeyInput = input[i + 5].substring(30)
    val monkey = Monkey(
        items = itemsInput.map { Item(it.toInt()) }.toMutableList(),
        operation = Operation(
            operand1 = if (operationInput[0] == "old") null else operationInput[0].toInt(),
            operand2 = if (operationInput[2] == "old") null else operationInput[2].toInt(),
            operator = operationInput[1][0],
        ),
        testFactor = testFactorInput.toInt(),
        truthyMonkey = truthyMonkeyInput.toInt(),
        falsyMonkey = falsyMonkeyInput.toInt(),
    )
    monkeys.add(monkey)
}

for (round in 0 until 20) {
    for (monkey in monkeys) {
        while (monkey.items.isNotEmpty()) {
            monkey.inspect()
            val nextMonkeyIndex = monkey.test()
            val item = monkey.throwItem()

            monkeys[nextMonkeyIndex].catchItem(item)
        }
    }
}

val inspectionCountComparator = Comparator { monkey1: Monkey, monkey2: Monkey -> monkey2.inspectionCount - monkey1.inspectionCount }
monkeys.sortWith(inspectionCountComparator)

Answer(monkeys[0].inspectionCount * monkeys[1].inspectionCount)