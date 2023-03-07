
/*
* Converts a time in seconds to hours, minutes and seconds.
*/
fun main() {
	print("Tempo em segundos ? ")
	val seconds = readln().trim().toInt()
	val h = seconds / 3600
	val m = seconds % 3600 / 60
	val s = seconds % 60
	println("$seconds segundos = $h:$m:$s")
}