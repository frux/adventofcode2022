package days.day11

class Monkey(
    val items: MutableList<Item>,
    private val operation: Operation,
    private val testFactor: Int,
    private val truthyMonkey: Int,
    private val falsyMonkey: Int,
) {
    var inspectionCount = 0
        private set

    fun inspect() {
        items[0].worry = operation.calculate(items[0].worry).floorDiv(3)
        inspectionCount += 1
    }

    fun inspectWithoutRelief(simplicityFactor: Int) {
        items[0].worry = operation.calculate(items[0].worry) % simplicityFactor
        inspectionCount += 1
    }

    fun test(): Int {
        return if (items[0].worry % testFactor == 0L) truthyMonkey else falsyMonkey
    }

    fun throwItem() = items.removeFirst()

    fun catchItem(item: Item) {
        items.add(item)
    }
}