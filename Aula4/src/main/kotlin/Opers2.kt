fun main() {
    op('+',"Soma")
    op('-',"Subtração")
    op('x',"Multiplicação")
    op('/',"Divisão")
}

private fun op(symbol: Char, name: String) {
    println("$name:")
    val a = readInt("A")
    val b = readInt("B")
    val res = when(symbol) {
        '+' -> a + b
        '-' -> a - b
        'x' -> a * b
        else -> 0 // Smell code
    }
    println("$name: $a $symbol $b = $res")
}