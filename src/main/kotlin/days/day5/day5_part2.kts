import answer.Answer
import days.day5.CrateMover9001
import days.day5.CratesStack
import input.InputReader
import java.util.EmptyStackException

val input = InputReader(day = 5, part = 2).getLines()
val commandsStartIndex = input.indexOf("") + 1
val stack = mutableListOf<CratesStack>()

for (i in commandsStartIndex - 3 downTo 0) {
    val line = input[i]

    for (j in 1 until line.length step 4) {
        val crate = line[j]
        val stackIndex = j.floorDiv(4)

        if (stack.size <= stackIndex) {
            stack.add(CratesStack())
        }

        if (crate == ' ') {
            continue
        }

        stack[stackIndex].put(crate)
    }
}

val crane = CrateMover9001(stack)
var answer = ""

for (i in commandsStartIndex until input.size) {
    val command = input[i].split(' ')
    val quantity = command[1].toInt()
    val from = command[3].toInt()
    val to = command[5].toInt()

    crane.move(quantity, from, to)
}

for (stack in crane.getStacks()) {
    answer += try { stack.take() } catch (e: EmptyStackException) { ' ' }
}

Answer(answer)