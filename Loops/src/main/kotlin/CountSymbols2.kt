
// Using do-while loop

fun main() {
    var symbols = 0
    do {
        val line = readlnOrNull()
        println(line)
        if (line!=null) {
            val letters = line.filter { it.isLetter() }
            symbols += letters.length
        }
    } while( line!=null )
    println("Total simbolos= $symbols")
}