
/**
 *  Read a list of integers separated by spaces
 *  after printing the [question] and returns it.
 */
fun readInts(question: String): List<Int> {
    print("$question? ")
    return readln()         // String
        .split(' ')         // List<String>
        .filter { it.isNotEmpty() } // if one or more spaces are used between numbers
        .map { it.toInt() } // List<Int>
}

/**
 *  Read a list of integers separated by spaces
 *  after printing the [question] and returns it.
 *  The list must have at least [minSize] elements.
 */
fun readInts(quest: String, minSize: Int): List<Int> {
    var values: List<Int>
    do {
        values = readInts(quest)
    } while (values.size < minSize)
    return values
}

/**
 *  Read a bet (with numbers and stars) and returns it.
 */
fun readBet(question: String): Bet {
    println("$question: ")
    val numbers = readInts("Numbers",MIN_SIZE_NUMBERS)
    val stars = readInts("Stars",MIN_SIZE_STARS)
    return Bet(numbers, stars)
}

/**
 *  Program to read a bet and print it.
 */
fun main() {
    val bet = readBet("Bet")
    println(bet)
}