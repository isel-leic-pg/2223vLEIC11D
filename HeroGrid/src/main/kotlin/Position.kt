import Direction.*
import kotlin.math.abs

/**
 * The direction of a move or turn.
 */
enum class Direction(val dRow: Int = 0, val dCol: Int = 0) {
     DOWN(dRow = +1), LEFT(dCol = -1), RIGHT(dCol = +1), UP(dRow = -1)
}

/**
 * Represents a position in the grid.
 * @property row the row of the position
 * @property col the column of the position
 */
data class Position(val row: Int, val col: Int)

/**
 * All positions in the grid
 */
val allPositions = List(GRID_ROWS*GRID_COLS) { Position(row=it/GRID_COLS, col=it%GRID_COLS) }

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
    DOWN -> Position(row + 1, col)
    UP -> Position(row - 1, col)
    LEFT -> Position(row, col - 1)
    /*else*/ RIGHT -> Position(row, col + 1)
}

/**
 * Direction from one position to other position.
 * @receiver the position from which the direction is computed
 * @param to the position to which the direction is computed
 * @return the direction from this position to the given position
 */
fun Position.dirTo(to: Position): Direction {
    val dRow = to.row - row
    val dCol = to.col - col
    return if (abs(dRow) > abs(dCol))
        if (dRow > 0) DOWN else UP
    else
        if (dCol > 0) RIGHT else LEFT
}

/**
 * Returns positions that are repeated in the list.
 */
fun List<Position>.duplicates() = filter { it in (this-it) }.distinct()
