
fun add(x: Int, y: Int) = x + y

fun main() {
    val sub = {a:Int, b:Int -> a-b }
    op('+',"Soma",::add)
    op('-',"Subtração",sub)
    op('x',"Multiplicação", {x,y -> x*y})
    op('/',"Divisão") { a,b ->
        print("ha ha ha")
        a/b
    }
}

private fun op(symbol: Char, name: String, fx: (Int,Int)->Int ) {
    println("$name:")
    val a = readInt("A")
    val b = readInt("B")
    val res = fx(a,b)
    println("$name: $a $symbol $b = $res")
}