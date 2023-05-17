/**
 * Represents the game state with the
 * [hero] moved by the user,
 * a list of [robots] following the hero and
 * a list of [garbage] positions resulting from robot collisions.
 */
data class Game(
    val hero: Actor,
    val robots: List<Actor>,
    val garbage: List<Position>,
)

/**
 * Maximum number of robots in the game
 */
const val MAX_ROBOTS = 10

/**
 * Creates a new game with the hero, a list of robots and no garbage.
 */
fun createGame() = Game(
    hero = createHero(),
    robots = List(MAX_ROBOTS){ createRobot() },//listOf(Actor(Position(4,8)), Actor(Position(5,7))),
    garbage = emptyList()
)

/**
 * Moves the hero in the given direction and robots in direction to the hero.
 * @receiver the game to be moved
 * @param dir the direction to move the hero
 * @return the new game after the move
 */
fun Game.move(dir: Direction): Game {
    if (hero.walk!=Walk.STAND)
        return step().move(dir)
    val newHero = hero.move(dir)
    return copy(
        hero = newHero,
        robots = robots.map { it.move(it.pos.dirTo(newHero.finalPosition())) }
    )
}

/**
 * Returns positions that are repeated in the list.
 */
fun List<Position>.duplicates() = filter { it in (this-it) }.distinct()

/**
 * Moves one walk step the hero and the robots in the direction it is facing.
 * @receiver the game to be moved
 * @return the new game after the walk step
 */
fun Game.step() =
    if (hero.walk==Walk.STAND) this
    else {
        val newHero = hero.step()
        val newRobots = robots.map { it.step() }
        if (newHero.walk!=Walk.STAND)
            copy(hero = newHero, robots = newRobots)
        else {
            val remainingRobots = newRobots.filter { it.pos !in garbage }
            val collidePositions = remainingRobots.map { it.pos }.duplicates()
            val newGarbage = garbage + collidePositions
            val finalRobots = remainingRobots.filter { it.pos !in collidePositions }
            Game(hero = newHero, robots = finalRobots, garbage = newGarbage)
        }
    }


