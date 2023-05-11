
/**
 * Represents the state of the game.
 * @property frog the frog representation
 * @property cars the list of cars in the game
 */
data class Frogger(
    val frog: Frog,
    val cars: List<Car>
)

/**
 * Verifies if the frog collides with any car.
 * @return the game with the frog smashed if it collides with any car, the same game otherwise.
 */
fun Frogger.detectCollision(): Frogger =
    if (frog.collide(cars)) copy( frog= frog.smashed() )
    else this