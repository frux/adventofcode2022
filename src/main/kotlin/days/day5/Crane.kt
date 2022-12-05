package days.day5

class Crane(private val stacks: List<CratesStack>) {
    fun move(from: Int, to: Int) {
        stacks[to - 1].put(stacks[from - 1].take())
    }

    fun getStacks() = stacks
}