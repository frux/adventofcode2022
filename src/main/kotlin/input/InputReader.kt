package input

class InputReader(day: Number, part: Number) {
    private val filePath = "/input/days/${day}/${part}.txt"

    private fun read(): String {
        return this::class.java.getResource(filePath)?.readText(Charsets.UTF_8)
            ?: throw Error("Input resource not found")
    }

    fun getText() = read()

    fun getLines() = read().split('\n')

    fun getNumbers() = getLines().map { it.toInt() }

    fun getChars() = getLines()[0].toList()
}