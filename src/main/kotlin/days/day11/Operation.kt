package days.day11

class Operation(
    private val operand1: Long?,
    private val operand2: Long?,
    private val operator: Char,
) {
    companion object {
        const val ADD = '+'
        const val MULTIPLY = '*'
        const val SUBSTRACT = '-'
        const val DIVIDE = '/'
    }

    fun calculate(old: Long): Long {
        val a = (operand1 ?: old)
        val b = (operand2 ?: old)

        return when (operator) {
            ADD -> a + b
            MULTIPLY -> a * b
            SUBSTRACT -> a - b
            DIVIDE -> a / b
            else -> throw Error("Unknown operator $operator")
        }
    }
}