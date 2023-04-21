import Direction.*

/**
 * Represents the walking state of the actor.
 * STAND: Actor is standing still
 * START: Actor is starting to walk
 * MID: Actor is walking in the middle of the square
 * END: Actor is ending the walk
 */
enum class Walk { STAND, START, MID, END }

/**
 * Represents the actor in arena
 * @property pos actor position in the grid
 * @property dir direction of the actor is facing
 * @property walk walking state of the actor
 */
data class Actor(
    val pos: Position,
    val dir: Direction = DOWN,
    val walk: Walk = Walk.STAND
)

/**
 * Move the actor after turning to the given direction.
 * @receiver the actor to be moved
 * @param to the direction to move
 * @return the new actor after the move
 */
fun Actor.move(to: Direction): Actor =
    if (walk==Walk.STAND)
        if ((pos + to).isValid())
            face(to).copy(walk = Walk.START)
        else
            face(to)
    else
        copy(walk=Walk.END).step().move(to)

/**
 * Move the actor in the direction it is facing.
 * @receiver the actor to be moved
 * @return the new actor after the move
 */
fun Actor.moveFaced(): Actor {
    val pos = pos + dir
    return if (pos.isValid()) copy(pos= pos) else this
}

/**
 * Turn the actor to the given direction.
 * @receiver the actor to be turned
 * @param to the direction to turn
 * @return the new actor after the turn
 */
fun Actor.face(to: Direction) =
    if (dir==to) this else copy(dir= to)

/**
 * Moves the actor one step in the animation walk
 * @receiver the actor before the step
 * @return the new actor after the step
 */
fun Actor.step(): Actor = when(walk) {
    Walk.STAND -> this
    Walk.START -> copy(walk = Walk.MID)
    Walk.MID -> copy(walk = Walk.END)
    Walk.END -> copy(walk = Walk.STAND, pos= pos+dir)
}

/**
 * Creates an actor in the center of the grid.
 * @return the actor created
 */
fun createHero() = Actor(
    Position(GRID_ROWS / 2, GRID_COLS / 2),
)

/**
 * Creates an actor in a random position in the grid.
 * @return the actor created
 */
fun createRobot() = Actor(
    Position( (0 until GRID_ROWS).random(), (0 until GRID_COLS).random() ),
)

/**
 *
 */
fun Actor.finalPosition() =
    if (walk == Walk.STAND) pos else pos+dir






