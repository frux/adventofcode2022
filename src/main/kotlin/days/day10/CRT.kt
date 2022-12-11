package days.day10

class CRT(private val spriteIterator: Iterator<Int>) {
    companion object {
        const val WIDTH = 40
        const val HEIGHT = 6
    }

    fun render(): String {
        var image = ""

        for (i in 0 until WIDTH * HEIGHT) {
            val pixelPosition = i % 40
            val spritePosition = spriteIterator.next()

            if (pixelPosition == 0) {
                image += "\n"
            }

            val isLit = pixelPosition >= spritePosition - 1 && pixelPosition <= spritePosition + 1
            image += if (isLit) "#" else " "
        }

        return image
    }
}