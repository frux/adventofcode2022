package days.day7

class Directory(name: String, parent: Directory?): Node(name, parent) {
    val children = mutableSetOf<Node>()

    fun addChild(node: Node) {
        children.add(node)
    }

    fun findByName(name: String): Node? {
        for (child in children) {
            if (child.name == name) {
                return child
            }
        }

        return null
    }

    override val size: UInt
        get(): UInt = children.fold(0u){size, child -> size + child.size}
}