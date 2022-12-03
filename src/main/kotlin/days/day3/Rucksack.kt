package days.day3

class Rucksack(private val items: String) {
    fun getRearrangementPriority(): Int {
        val leftCompartment = mutableMapOf<Char, Int>()
        val rightCompartment = mutableMapOf<Char, Int>()
        val compartmentSize = items.length / 2

        for (i in 0 until compartmentSize) {
            val leftItem = items[i]
            val rightItem = items[i + compartmentSize]

            if (rightCompartment[leftItem] != null) {
                return getItemPriority(leftItem)
            }

            if (leftCompartment[rightItem] != null) {
                return getItemPriority(rightItem)
            }

            if (rightItem == leftItem) {
                return getItemPriority(rightItem)
            }

            leftCompartment[leftItem] = (leftCompartment[leftItem] ?: 0) + 1
            rightCompartment[rightItem] = (rightCompartment[rightItem] ?: 0) + 1
        }

        return 0
    }

    companion object {
        private fun getItemPriority(item: Char): Int {
            return if (item.code > 90) item.code - 96 else item.code - 38
        }
    }
}