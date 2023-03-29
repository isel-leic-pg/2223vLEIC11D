/**
 * The direction of a move or turn.
 */
enum class Direction { DOWN, LEFT, RIGHT, UP }

/**
 * Represents a position in the grid.
 * @property row the row of the position
 * @property col the column of the position
 */
data class Position(val row: Int, val col: Int)

/**
 * Checks if the position is valid in grid.
 * @receiver the position to be checked
 * @return true if the position is valid, false otherwise
 */
fun Position.isValid(): Boolean =
    row in 0 until GRID_ROWS && col in 0 until GRID_COLS

/**
 * Adds the direction to the position.
 * The new direction may be invalid.
 * @receiver the position to be added
 * @param dir the direction to be added
 * @return the new position after the addition
 */
operator fun Position.plus(dir: Direction) = when(dir) {
    Direction.DOWN -> Position(row + 1, col)
    Direction.UP -> Position(row - 1, col)
    Direction.LEFT -> Position(row, col - 1)
    Direction.RIGHT -> Position(row, col + 1)
}