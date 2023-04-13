/**
 * Represents a game state with one hero and one robot that chases the hero.
 */
data class Game(val hero: Actor, val robot: Actor)

/**
 * Creates a new game with a hero and a robot.
 */
fun createGame() = Game(
    hero = createHero(),
    robot = createRobot()
)

/**
 * Moves the hero in the given direction and the robot in direction to the hero.
 * @receiver the game to be moved
 * @param dir the direction to move the hero
 * @return the new game after the move
 */
fun Game.move(dir: Direction) = Game(
    hero = hero.move(dir),
    robot = robot.move( robot.pos.dirTo(hero.pos) )
)

/**
 * Moves one walk step the hero and the robot in the direction it is facing.
 * @receiver the game to be moved
 * @return the new game after the move
 */
fun Game.step() = Game(
    hero = hero.step(),
    robot = robot.step()
)


