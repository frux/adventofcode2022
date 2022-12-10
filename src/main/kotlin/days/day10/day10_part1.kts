import answer.Answer
import days.day10.CPU
import input.InputReader

val input = InputReader(day = 10, part = 1).getLines()
val program = input.map{
    val parts = it.split(" ")
    Pair(parts[0], parts.getOrNull(1)?.toInt())
}.asSequence()
val cpu = CPU(program.iterator())

var signalStrengthSum = 0

for (i in 1 .. 220) {
    val x = cpu.tick() ?: throw Error("Unexpected end of program")

    if (i % 40 == 20) {
        signalStrengthSum += x * i
    }
}

Answer(signalStrengthSum)
