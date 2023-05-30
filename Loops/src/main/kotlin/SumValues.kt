

fun main() {
    val words = readln().split(" ")
    val values = words.map{ it.toInt() }
    println(values)
    println(values.sum())
}

fun String.toValues(): List<Int> {
    val l = mutableListOf<Int>()
    var value = 0
    for(c in this) {
        if (c in '0'..'9') {
            value = value*10 + (c-'0')
        } else {
            l.add(value)
            value = 0
        }
    }
    if (value!=0) l.add(value)
    return l
}