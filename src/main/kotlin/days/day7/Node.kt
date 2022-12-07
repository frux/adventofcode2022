package days.day7

abstract class Node(val name: String, val parent: Directory?) {
    abstract val size: UInt
    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun equals(other: Any?) = other is Node && name == other.name
}
