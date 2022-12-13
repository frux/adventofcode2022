import answer.Answer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import input.InputReader

val parseType = object : TypeToken<List<Any>>() { }.type
val gson = Gson()
fun parse(line: String) = gson.fromJson<List<String>>(line, parseType)

val input = InputReader(day = 13, part = 1).getLines()
var rightOrderPackets = mutableListOf<Int>()

for (i in input.indices step 3) {
    val packetNumber = i.floorDiv(3) + 1
    val packet1 = parse(input[i])
    val packet2 = parse(input[i + 1])

    if (isRightOrder(packet1, packet2) == 1) {
        rightOrderPackets.add(packetNumber)
    }
}

fun isRightOrder(packet1: Any, packet2: Any): Int {
    return when {
        packet1 is Double && packet2 is Double -> when {
            packet1 == packet2 -> 0
            packet1 < packet2 -> 1
            else -> -1
        }
        packet1 is List<*> && packet2 is Double -> isRightOrder(packet1, listOf(packet2))
        packet1 is Double && packet2 is List<*> -> isRightOrder(listOf(packet1), packet2)
        packet1 is List<*> && packet2 is List<*> -> {
            for (i in packet1.indices) {
                if (i > packet2.lastIndex) {
                    return -1
                }

                val verdict = isRightOrder(packet1[i]!!, packet2[i]!!)

                if (verdict == 0) {
                    continue
                } else {
                    return verdict
                }
            }

            return if (packet1.size < packet2.size) 1 else 0
        }
        else -> throw Error("Pair of unknown type")
    }
}

Answer(rightOrderPackets.sum())