
const val MIN_SIZE_NUMBERS = 5  // A bet must have at least 5 numbers
const val MIN_SIZE_STARS = 2    // A bet must have at least 2 stars
const val MAX_NUMBER = 50       // The maximum value of a number is 50
const val MAX_STAR = 12         // The maximum value of a star is 12

/**
 * A bet is composed of a list of [numbers] and a list of [stars].
 */
data class Bet(val numbers: List<Int>, val stars: List<Int>)

val allNumbers = List(MAX_NUMBER){ it+1 }   // All numbers from 1 to MAX_NUMBER
val allStars = (1..MAX_STAR).toList()       // All stars from 1 to MAX_STAR

/**
 * Takes a random sample of [n] elements from the list.
 */
fun List<Int>.takeRandom(n: Int) = shuffled().take(n).sorted()

/**
 * Generates a random single bet.
 */
fun genRandomSingleBet() = Bet(
    allNumbers.takeRandom(MIN_SIZE_NUMBERS),
    allStars.takeRandom(MIN_SIZE_STARS)
)