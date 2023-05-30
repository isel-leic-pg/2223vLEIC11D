

fun main(args: Array<String>) {
    println(args.size)
    println(args.toList())
    val values = args.map{ it.toInt() }
    println(values)
    println(values.sum())

    val a = arrayOf(1,2,3)
    val b = a + 10
    val c = a - 2
    println(b.toList())
}