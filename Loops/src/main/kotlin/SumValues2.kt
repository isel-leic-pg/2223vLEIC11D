

fun main(args: Array<String>) {
    println(args.size)
    println(args.toList())
    val values = args.map{ it.toInt() }
    println(values)
    println(values.sum())
}