
// Using infinite while loop with break

fun main() {
    var symbols = 0
    while(true) {
        val line = readlnOrNull() ?: break
        println(line)
        val letters = line.filter { it.isLetter() }
        symbols += letters.length
    }
    println("Total simbolos= $symbols")
}