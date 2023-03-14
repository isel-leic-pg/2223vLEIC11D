

fun main() {
  val number = readInt("Numero")
  val type = when {
	number == 0 -> "zero e positivo"
	number > 0 -> "positivo"
	else -> "negativo"
  }
  println("$number é $type")  
}