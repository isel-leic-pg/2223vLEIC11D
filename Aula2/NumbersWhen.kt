

fun main() {
  print("Numero? ")
  
  val number: Int = readln().trim().toInt()
  
  val type = when {
	number == 0 -> "zero e positivo"
	number > 0 -> "positivo"
	else -> "negativo"
  }
  /*
  when (number) {
	0 -> "zero e positivo"
	in 1..(Int.MAX_VALUE) -> "positivo"
	else -> "negativo"
  }
  */
  println("$number é $type")  
}