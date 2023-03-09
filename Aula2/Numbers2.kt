

fun main() {
  print("Numero? ")
  
  val number: Int = readln().trim().toInt()
  
  val type = 
    if (number >=0)
		if (number==0) "zero e positivo" 
		else "positivo" 	
	else "negativo"
  
  println("$number é $type")  
}