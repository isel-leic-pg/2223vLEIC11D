
fun typeOfTriangle(a: Int, b: Int, c: Int): String = when {
	a>=b+c || b>=a+c || c>=a+b 	-> 	"inválido"
	a==b && a==c 				->  "equilatero"
	a==b || a==c || b==c 		-> 	"isósceles"
	else 						-> 	"escaleno"
}

fun main(): Unit {
	println(typeOfTriangle(3,3,3)=="equilatero")
	println(typeOfTriangle(2,2,3)=="isósceles")
	println(typeOfTriangle(4,2,3)=="escaleno")
	println(typeOfTriangle(7,3,3)=="inválido")


    val s1 = readInt("Lado A")
    val s2 = readInt("Lado B")
    val s3 = readInt("Lado C")	
	val type = typeOfTriangle(s1,s2,s3) 
	println("O triangulo é $type")
}