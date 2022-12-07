package days.day7

class FileSystem {
    val root = Directory("/", null)
    var pwd = root
        private set

    fun ls(node: Node = pwd): String {
        val output = mutableListOf<String>()

        when(node) {
            is Directory -> {
                output.add("- ${node.name} (dir)")

                for (child in node.children) {
                    ls(child).split("\n").forEach { output.add("\t$it") }
                }
            }
            is File -> {
                output.add("- ${node.name} (file, size=${node.size})")
            }
            else -> throw Error("Unknown type of node")
        }

        return output.joinToString("\n")
    }

    fun mkdir(name: String, node: Node = pwd): Directory {
        if (node !is Directory) {
            throw Error("Parent node should be a directory")
        }

        val directory = Directory(name, node)
        node.addChild(directory)

        return directory
    }

    fun touch(name: String, size: UInt, node: Node = pwd): File {
        if (node !is Directory) {
            throw Error("Parent node should be a directory")
        }

        val file = File(name, size, node)
        node.addChild(file)

        return file
    }

    fun cd(dirName: String) {
        val node = when (dirName) {
            ".." -> pwd.parent ?: root
            "/" -> root
            else -> pwd.findByName(dirName) ?: throw Error("Directory $dirName not found")
        }

        if (node !is Directory) {
            throw Error("$dirName is not a directory")
        }

        pwd = node
    }
}