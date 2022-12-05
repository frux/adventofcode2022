package days.day5

import java.util.*

class CratesStack(private var crates: Stack<Char> = Stack()) {
    fun take() = crates.pop()
    fun put(crate: Char) = crates.push(crate)

    fun getCrates() = crates.toList()
}