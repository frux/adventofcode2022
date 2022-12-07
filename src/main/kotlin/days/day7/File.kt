package days.day7

class File(name: String, override val size: UInt, parent: Directory): Node(name, parent)