
fun dice() {
	val n1 = (1..6).random()
	val n2 = (1..6).random()
	val total =  (n1+n2) * if (n1==n2) 2 else 1
	println("($n1) ($n2) -> $total")
	if (n1==n2 && confirm(quest="Lançar novamente"))
		dice()
}

fun main() {
	dice()
}