
// Using for loop in range

fun main() {
    var symbols = 0
    for (i in 1..100) {
        val line = readlnOrNull() ?: break
        println("$i: $line")
        val letters = line.filter { it.isLetter() }
        symbols += letters.length
    }
    println("Total simbolos= $symbols")
}