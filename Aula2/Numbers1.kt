

fun main() {
  print("Numero? ")
  
  val number = readln().trim().toInt()
  
  if (number >= 0) {
	if (number == 0) println("$number é zero")
	println("$number é positivo")
  } 
  else println("$number é negativo")  
}