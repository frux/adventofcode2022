import answer.Answer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import input.InputReader

val parseType = object : TypeToken<List<Any>>() { }.type
val gson = Gson()
fun parse(line: String) = gson.fromJson<List<String>>(line, parseType)

val input = InputReader(day = 13, part = 2).getLines()
val divider1 = listOf(listOf(2.0))
val divider2 = listOf(listOf(6.0))
val packets = mutableListOf<List<Any>>(divider1, divider2)

for (i in input.indices step 3) {
    packets.add(parse(input[i]))
    packets.add(parse(input[i + 1]))
}

packets.sortWith { a: List<Any>, b: List<Any> -> isRightOrder(a, b) * -1 }

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

Answer((packets.indexOf(divider1) + 1) * (packets.indexOf(divider2) + 1))