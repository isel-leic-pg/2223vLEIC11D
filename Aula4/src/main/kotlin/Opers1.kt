fun main() {
    opPlus()
    opMinus()
    // mais operações
}

fun opPlus() {
    println("Soma:")
    val a = readInt("A")
    val b = readInt("B")
    val res = a + b
    println("Soma: $a + $b = $res")
}

fun opMinus() {
    println("Subtração:")
    val a = readInt("A")
    val b = readInt("B")
    val res = a - b
    println("Subtração: $a - $b = $res")
}