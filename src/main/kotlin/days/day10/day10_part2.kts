import answer.Answer
import days.day10.CPU
import days.day10.CRT
import days.day10.Device
import input.InputReader
import kotlin.math.sign

val input = InputReader(day = 10, part = 2).getLines()
val program = input.map{
    val parts = it.split(" ")
    Pair(parts[0], parts.getOrNull(1)?.toInt())
}.asSequence()
val device = Device(program.iterator())

Answer("\n" + device.renderImage())
