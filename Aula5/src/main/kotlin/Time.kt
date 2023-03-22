

fun seconds(h: Int, m: Int, s: Int) = h * 3600 + m * 60 + s

data class Time(val h: Int, val m: Int, val s: Int)

fun time(secs: Int): Time {
    val h = secs / 3600
    val m = (secs - h*3600) / 60
    return Time(h , m, secs % 60)
}


fun main() {
    val secs = seconds(2,30,0)
    println("total = $secs")
    val t: Time = Time(4,25,30)
    println(t.h)
    println(t)
    println(time(3666))
}