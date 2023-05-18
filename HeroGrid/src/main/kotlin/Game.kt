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
fun createGame(): Game {
    val hero = createHero()
    return Game(
        hero = hero,
        robots = createRobots(hero.pos),
        garbage = emptyList()
    )
}

/**
 * Creates a list of robots in random positions.
 * @param exclude the position to exclude
 * @return the list of robots created
 */
fun createRobots(exclude: Position): List<Actor> =
    (allPositions-exclude).shuffled().take(MAX_ROBOTS).map { Actor(it) }
/*
    var result: List<Position> = emptyList()
    while(result.size < MAX_ROBOTS) {
        val pos = Position(
            row = (0 until GRID_ROWS).random(),
            col = (0 until GRID_COLS).random()
        )
        if (pos != exclude && pos !in result)
            result = result + pos
    }
    return result.map{ Actor(it) }
*/

/**
 * Moves the hero in the given direction and robots in direction to the hero.
 * @receiver the game to be moved
 * @param dir the direction to move the hero
 * @return the new game after the move
 */
fun Game.move(dir: Direction): Game {
    if (hero.walking())
        return step().move(dir)
    val newHero = hero.move(dir)
    return copy(
        hero = newHero,
        robots = robots.map { it.move(it.pos.dirTo(newHero.finalPosition())) }
    )
}

/**
 * Makes the hero jump to a random position.
 * @receiver the actual game
 * @return the new game after the jump
 */
fun Game.jump(): Game {
    if (hero.walking()) return this
    val pos = (allPositions-garbage-hero.pos-robots.map { it.pos }).random()
    val newHero = hero.copy(pos=pos, dir = Direction.DOWN)
    return copy(
        hero = newHero,
        robots = robots.map { it.move(it.pos.dirTo(newHero.finalPosition())) }
    )
}

/**
 * Moves one walk step the hero and the robots in the direction it is facing.
 * @receiver the game to be moved
 * @return the new game after the walk step
 */
fun Game.step() =
    if (hero.stopped()) this
    else {
        val newGame = copy(
            hero = hero.step(),
            robots = robots.map { it.step() }
        )
        if (newGame.hero.walking()) newGame
        else newGame.detectCollisions()
    }

/**
 * Excludes robots that collide with garbage.
 * Turns two or more colliding robots into trash.
 * @receiver the game to be checked
 * @return the new game after the collision resolution
 */
fun Game.detectCollisions(): Game {
    val remainingRobots = robots.filter { it.pos !in garbage }
    val collidePositions = remainingRobots.map { it.pos }.duplicates()
    val newGarbage = garbage + collidePositions
    val finalRobots = remainingRobots.filter { it.pos !in collidePositions }
    return copy(robots = finalRobots, garbage = newGarbage)
}


