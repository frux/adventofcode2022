import answer.Answer
import input.InputReader

val windowSize = 14
val input = InputReader(day = 6, part = 2).getChars()
var pointer = 0

charLoop@ while (pointer <= input.size - windowSize) {
    val windowLastIndex = pointer + windowSize - 1
    val window = mutableSetOf(input[windowLastIndex])

    for (i in (windowLastIndex - 1) downTo pointer) {
        val char = input[i]
        if (window.contains(char)) {
            pointer = i + 1
            continue@charLoop
        }
        window.add(char)
    }

    Answer(windowLastIndex + 1)
    break
}