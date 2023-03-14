
fun readInt(quest: String): Int {
	print("$quest? ")
	return readln().trim().toInt()
}

fun confirm(quest: String = "Confirm"): Boolean {
	print("$quest? (s/n) ")
	return readln()[0] in "sSyY"
}

