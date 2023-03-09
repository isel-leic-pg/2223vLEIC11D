

fun main() {
	val n1 = (1..6).random()
	val n2 = (1..6).random()
	val total =  (n1+n2) * if (n1==n2) 2 else 1
	println("($n1) ($n2) -> $total")
	/*
	print("Lançar novamente? (s/n) ")
	val again: Boolean = readln()[0] in "sS"
	*/
}