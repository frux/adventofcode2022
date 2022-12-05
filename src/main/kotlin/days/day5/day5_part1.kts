import answer.Answer
import days.day5.Crane
import days.day5.CratesStack
import input.InputReader
import java.util.EmptyStackException

val input = InputReader(day = 5, part = 1).getLines()
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

val crane = Crane(stack)
var answer = ""

for (i in commandsStartIndex until input.size) {
    val command = input[i].split(' ')
    val quantity = command[1].toInt()
    val from = command[3].toInt()
    val to = command[5].toInt()

    for (j in 1..quantity) {
        crane.move(from, to)
    }
}

for (stack in crane.getStacks()) {
    answer += try { stack.take() } catch (e: EmptyStackException) { ' ' }
}

Answer(answer)