
fun readValue(n: Int): Int {
    print("${n}º Valor? ")
    return readln().trim().toInt()
}

fun main() {
    val a = readValue(1)
    val b = readValue(2)
    val c = readValue(3)

    val n = when {
        a>=b && a>=c -> 1
        b>=a && b>=c -> 2
        else -> 3
    }

    val avg = (a + b + c) / 3F

    println("O maior valor é o ${n}º e a média dos 3 valores é $avg")
}