package days.day14

class Sand() {
    var x = 500
        private set
    var y = 0
        private set

    fun fall(cave: Map<Int, Map<Int, Int>>): Boolean {
        when {
            cave[x]?.get(y + 1) == null -> {
                y += 1
                return true
            }
            cave[x-1]?.get(y + 1) == null -> {
                x -= 1
                y += 1
                return true
            }
            cave[x+1]?.get(y + 1) == null -> {
                x += 1
                y += 1
                return true
            }
            else -> return false
        }
    }
}