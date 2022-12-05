package days.day5

class CrateMover9000(private val stacks: List<CratesStack>) {
    fun move(from: Int, to: Int) {
        stacks[to - 1].put(stacks[from - 1].take())
    }

    fun getStacks() = stacks
}