import answer.Answer
import days.day7.Directory
import days.day7.FileSystem
import input.InputReader

val input = InputReader(day = 7, part = 1).getLines()
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

val maxSize = 100000u
fun calculateTotalSize(dir: Directory): UInt {
    val size = dir.size
    var totalSize = if (size > maxSize) 0u else dir.size

    for (child in dir.children) {
        if (child !is Directory) {
            continue
        }

        totalSize += calculateTotalSize(child)
    }

    return totalSize
}

Answer(calculateTotalSize(fs.root))