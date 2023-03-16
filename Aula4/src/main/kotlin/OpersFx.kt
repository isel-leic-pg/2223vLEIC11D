

fun sub(x: Int, y: Int): Int {
    println("sub")
    return x - y
}

fun main() {
    val f: (Int,Int)->Int = fun (a:Int, b:Int) = a + b // ::sub
    println(f(2,3))
    val fx: (Int)->String = {
        println("lambda")
        "-$it-"
    }
    println(fx(27))
    /*
    op('+',"Soma")
    op('-',"Subtração")
    op('x',"Multiplicação")
    op('/',"Divisão")
     */
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