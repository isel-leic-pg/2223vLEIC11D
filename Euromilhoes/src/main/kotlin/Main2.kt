
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
 *  All elements must be between 1 and [maxValue].
 *  All elements must be different.
 *  If the list does not meet the requirements, it is read again.
 */
fun readInts(quest: String, minSize: Int, maxValue: Int): List<Int> {
    var values: List<Int>
    do {
        values = readInts(quest)
    } while (values.size < minSize || !values.validate(maxValue))
    return values
}

/**
 *  Returns true if the list has no repeated elements
 *  and all elements are between 1 and [max].
 */
fun List<Int>.validate(max :Int): Boolean {
     forEach {
         if (it !in 1..max) return false
     }
     return ! repeated()
}

/**
 *  Returns true if the list has repeated elements.
 */
fun List<Int>.repeated(): Boolean {
    for(j in 0..size-2 ) {
        val elem = this[j]
        for (i in j+1 until size)
            if (this[i] == elem) return true
    }
    return false
}

/**
 *  Read a bet (with numbers and stars) and returns it.
 */
fun readBet(question: String): Bet {
    println("$question: ")
    val numbers = readInts("Numbers",MIN_SIZE_NUMBERS,MAX_NUMBER)
    val stars = readInts("Stars",MIN_SIZE_STARS,MAX_STAR)
    return Bet(numbers, stars)
}

/**
 *  Program to read a bet and print it.
 */
fun main() {
    //val bet = readBet("Bet")
    //println(bet)
    println( listOf(3,7,2,4).repeated() )
    println( listOf(3,7,2,7).repeated() )
}