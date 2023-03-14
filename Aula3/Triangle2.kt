
fun main() {
	print("Lado A? ")
	val a = readln().trim().toInt()
	print("Lado B? ")
	val b = readln().trim().toInt()
	print("Lado C? ")
	val c = readln().trim().toInt()
	when {
		a>=b+c || b>=a+c || c>=a+b -> 
			println("O triangulo é inválido")
		a==b && a==c -> 
			println("O triangulo é equilatero")
		a==b || a==c || b==c -> 
			println("O triangulo é isósceles")
		else -> 
			println("O triangulo é escaleno")
	}			
}