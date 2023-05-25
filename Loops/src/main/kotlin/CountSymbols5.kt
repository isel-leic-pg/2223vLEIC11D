
// Using repeat loop (library function) with return

fun main() {
    var symbols = 0
    repeat(20) {
        val line = readlnOrNull()
        if (line==null) {
            println("Total simbolos= $symbols")
            return
        }
        println(line)
        val letters = line.filter { it.isLetter() }
        symbols += letters.length
    }
}