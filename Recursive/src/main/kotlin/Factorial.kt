fun main() {
    val n = 15
    println("$n! = ${factR(n)}")
    println("$n! = ${fact(n)}")
    println("$n! = ${factX(n)}")
}

/**
 * Recursive factorial function
 */
fun factR(n: Int): Long =
    if (n == 0) 1 else n * factR(n - 1)

/**
 * Iterative factorial function
 */
fun fact(n: Int): Long {
    var res = 1L
    for (i in 1..n)  res *= i
    return res
}

/**
 * Iterative factorial function using fold
 */
fun factX(n: Int) = (1..n).fold(1L) { a, i -> a * i }