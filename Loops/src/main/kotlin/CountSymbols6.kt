
// Using a function to read all lines

fun main() {
    val lines = readAllLines()
    var symbols = 0
    lines.forEachIndexed { idx, line ->
        println("${idx+1}: $line")
        val letters = line.filter { c -> c.isLetter() }
        symbols += letters.length
    }
    println("Total simbolos= $symbols")
}

/**
 * Read all lines from standard input and return them as a list of strings.
 */
fun readAllLines(): List<String> {
    val lines = mutableListOf<String>()
    while (true) {
        val line = readlnOrNull() ?: break
        lines.add(line)
    }
    return lines
}