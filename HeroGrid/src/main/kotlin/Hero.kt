/**
 * Represents the walking state of the hero.
 * STAND: the hero is standing still
 * START: the hero is starting to walk
 * MID: the hero is walking in the middle of the square
 * END: the hero is ending the walk
 */
enum class Walk { STAND, START, MID, END }

/**
 * Represents the hero in arena
 * @property pos the hero position in the grid
 * @property dir the direction the hero is facing
 * @property walk the walking state of the hero
 */
data class Hero(
    val pos: Position,
    val dir: Direction,
    val walk: Walk
)

/**
 * Move the hero after turning to the given direction.
 * @receiver the hero to be moved
 * @param to the direction to move
 * @return the new hero after the move
 */
fun Hero.move(to: Direction): Hero =
    if (walk==Walk.STAND)
        if ((pos + to).isValid())
            face(to).copy(walk = Walk.START)
        else
            face(to)
    else
        copy(walk=Walk.END).step().move(to)

/**
 * Move the hero in the direction it is facing.
 * @receiver the hero to be moved
 * @return the new hero after the move
 */
fun Hero.moveFaced(): Hero {
    val pos = pos + dir
    return if (pos.isValid()) copy(pos= pos) else this
}

/**
 * Turn the hero to the given direction.
 * @receiver the hero to be turned
 * @param to the direction to turn
 * @return the new hero after the turn
 */
fun Hero.face(to: Direction) =
    if (dir==to) this else copy(dir= to)

/**
 * Moves the hero one step in the animation walk
 * @receiver the hero before the step
 * @return the new hero after the step
 */
fun Hero.step(): Hero = when(walk) {
    Walk.STAND -> this
    Walk.START -> copy(walk = Walk.MID)
    Walk.MID -> copy(walk = Walk.END)
    Walk.END -> copy(walk = Walk.STAND, pos= pos+dir)
}

/**
 * Creates a hero in the center of the grid facing down.
 * @return the hero created
 */
fun createHero() = Hero(
    Position(GRID_ROWS / 2, GRID_COLS / 2),
    Direction.DOWN,
    Walk.STAND
)







