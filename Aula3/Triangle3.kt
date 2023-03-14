
fun main() {
	print("Lado A? ")
	val a = readln().trim().toInt()
	print("Lado B? ")
	val b = readln().trim().toInt()
	print("Lado C? ")
	val c = readln().trim().toInt()
	val type = when {
		a>=b+c || b>=a+c || c>=a+b 	-> 	"inválido"
		a==b && a==c 				->  "equilatero"
		a==b || a==c || b==c 		-> 	"isósceles"
		else 						-> 	"escaleno"
	}
	println("O triangulo é $type")
}