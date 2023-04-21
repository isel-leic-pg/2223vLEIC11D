/**
 * Represents a game state with one hero and a list of robots that chases the hero.
 */
data class Game(val hero: Actor, val robots: List<Actor>)

/**
 * Maximum number of robots in the game
 */
const val MAX_ROBOTS = 10

/**
 * Creates a new game with a hero and a list of robots.
 */
fun createGame() = Game(
    hero = createHero(),
    robots = List(MAX_ROBOTS){ createRobot() }
)

/**
 * Moves the hero in the given direction and robots in direction to the hero.
 * @receiver the game to be moved
 * @param dir the direction to move the hero
 * @return the new game after the move
 */
fun Game.move(dir: Direction): Game {
    val newHero = hero.move(dir)
    return Game(
        hero = newHero,
        robots = robots.map { it.move(it.pos.dirTo(newHero.finalPosition())) }
    )
}

/**
 * Moves one walk step the hero and the robots in the direction it is facing.
 * @receiver the game to be moved
 * @return the new game after the move
 */
fun Game.step() = Game(
    hero = hero.step(),
    robots = robots.map { it.step() }
)


