
// Using while do loop

fun main() {
    var symbols = 0
    var line = readlnOrNull()
    while( line!=null ) {
        println(line)
        val letters = line.filter { it.isLetter() }
        symbols += letters.length
        line = readlnOrNull()
    }
    println("Total simbolos= $symbols")
}