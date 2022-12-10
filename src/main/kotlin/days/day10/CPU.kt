package days.day10

import java.util.Stack

class CPU(private val program: Iterator<Pair<String, Int?>>) {
    private var x = 1
    private val stack = Stack<Int>()

    companion object {
        const val ADDX = "addx"
        const val NOOP = "noop"
    }

    fun tick(): Int? {
        if (stack.isEmpty() && !program.hasNext()) {
            return null
        }

        val xDuringThisCycle = x
        if (stack.isEmpty()) {
            nextCall()
        }

        eval()

        return xDuringThisCycle
    }

    private fun nextCall() {
        if (program.hasNext()) {
            val (instruction, value) = program.next()

            when (instruction) {
                ADDX -> {
                    if (value == null) {
                        throw Error("Value can not be empty")
                    }
                    stack.add(value)
                    stack.add(0)
                }
                NOOP -> {
                    stack.add(0)
                }
            }
        }
    }

    private fun eval() {
        x += stack.pop()
    }
}