package days.day5

class CrateMover9001(private val stacks: List<CratesStack>) {
    fun move(quantity: Int, from: Int, to: Int) {
        val tmpStack = CratesStack()

        for (i in 0 until quantity) {
            tmpStack.put(stacks[from - 1].take())
        }

        while (!tmpStack.isEmpty()) {
            stacks[to - 1].put(tmpStack.take())
        }
    }

    fun getStacks() = stacks
}