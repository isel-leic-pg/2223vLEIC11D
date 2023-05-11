
/**
 * Represents the state of a frog.
 * STAY, GONE and HOME are stable states, the others are intermediate states.
 * When frog is moved: STAY => MOVE->(STAY|HOME).
 * When frog is smashed: (STAY||MOVE) => SMASH_1->SMASH_2->SMASH_3->DEAD->GONE.
 * When frog is drowned: (STAY||MOVE) => DROWN_1->DROWN_2->DROWN_3->DEAD->GONE.
 */
enum class FrogState {
    STAY,   // Frog is not moving (in a cell)
    MOVE,   // Frog is moving between cells
    SMASH_1, SMASH_2, SMASH_3,  // Intermediate states when frog is smashed
    DROWN_1, DROWN_2, DROWN_3,  // Intermediate states when frog is drowned
    DEAD,   // Frog is dead
    GONE,   // Frog is hidden
    HOME    // Frog is in a home
}

/**
 * Number of frames to change for next state if current state is intermediate.
 */
private const val STATE_FRAMES = 5

/**
 * The information of the frog.
 * @property position the position (x and y) of the frog
 * @property dir the direction where the frog is facing (UP, LEFT, DOWN, RIGHT)
 * @property state the state of the frog
 * @property frames the number of frames left to change state
 */
data class Frog(
    val position: Point,
    val dir: Direction,
    val state: FrogState,
    val frames: Int = 0,
)

/**
 * Detect a collision between the frog and a movable object.
 */
fun Frog.collide(obj: Movable) =
    obj.row * GRID_SIZE == position.y && position.x+GRID_SIZE/2 in obj.toRangeX()

/**
 * Detect a collision between the frog and any car.
 */
fun Frog.collide(cars: List<Car>): Boolean {
    //for( i in cars.indices ) if (collide(cars[i].part)) return true
    //for(car in cars) if (collide(car.part)) return true
    //cars.forEach { if (collide(it.part)) return true }
    //return false
    return cars.any { collide(it.part) }
}

/**
 * Return a new frog in the same position but with the first state SMASHED
 */
fun Frog.smashed() = copy(state = FrogState.SMASH_1, frames = STATE_FRAMES)

/**
 * Return a new frog in the next state if the number of frames left is 0.
 * Otherwise, return the same frog with the number of frames left decreased by 1.
 */
fun Frog.step(): Frog =
    if (frames > 0) copy(frames = frames-1)
    else when(state) {
        FrogState.MOVE -> copy( state = FrogState.STAY, position = position+dir)
        FrogState.SMASH_1, FrogState.SMASH_2, FrogState.DROWN_1, FrogState.DROWN_2 ->
            copy(frames = STATE_FRAMES, state= FrogState.values()[state.ordinal+1])
        FrogState.SMASH_3, FrogState.DROWN_3 -> copy( state = FrogState.DEAD, frames = STATE_FRAMES)
        FrogState.DEAD -> copy( state = FrogState.GONE)
        else -> this
    }
