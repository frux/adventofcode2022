import answer.Answer
import days.day7.Directory
import days.day7.FileSystem
import input.InputReader

val input = InputReader(day = 7, part = 2).getLines()
val fs = FileSystem()

for (line in input) {
    when {
        line.startsWith("$ cd ") -> {
            val dirName = line.substring(5)
            fs.cd(dirName)
            continue
        }
        line.startsWith("$ ls") -> continue
        line.startsWith("dir ") -> {
            val dirName = line.substring(4)
            fs.mkdir(dirName)
            continue
        }
        else -> {
            val (size, name) = line.split(" ")
            fs.touch(name, size.toUInt())
            continue
        }
    }
}

val totalDiskSpace = 70000000u
val diskSpaceRequiredForUpdate = 30000000u
val rootSize = fs.root.size
val unusedSpace = totalDiskSpace - rootSize
val neededSpace = diskSpaceRequiredForUpdate - unusedSpace

fun getSmallestSizeToDelete(dir: Directory): UInt? {
    val size = dir.size

    if (size < neededSpace) {
        return null
    }

    var smallestSize = size

    for (child in dir.children) {
        if (child is Directory) {
            val childSmallestSize = getSmallestSizeToDelete(child)

            if (childSmallestSize != null && childSmallestSize < smallestSize) {
                smallestSize = childSmallestSize
            }
        }
    }

    return smallestSize
}

Answer(getSmallestSizeToDelete(fs.root) ?: 0u)