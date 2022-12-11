package days.day10

class Device(program: Iterator<Pair<String, Int?>>) {
    private val cpu = CPU(program)
    private val crt = CRT(generateSequence { cpu.tick() }.iterator())

    fun renderImage(): String = crt.render()
}