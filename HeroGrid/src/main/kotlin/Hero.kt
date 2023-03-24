import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE
import pt.isel.canvas.UP_CODE

/**
 * Represents the hero position in the grid
 * @property row the row in the grid (0..GRID_ROWS-1)
 * @property col the column in the grid (0..GRID_COLS-1)
 */
data class Hero(val row: Int, val col: Int)

/**
 * Moves the hero according to the key pressed
 * @param keyCode the key code that was pressed
 * @param h the hero to be moved
 * @return the new hero after the move
 */
fun moveHero(keyCode: Int, h: Hero): Hero {
    when (keyCode) {
        RIGHT_CODE ->
            if (h.col < GRID_COLS - 1) return Hero(h.row, h.col+1)
        LEFT_CODE ->
            if (h.col > 0) return Hero(h.row, h.col-1)
        DOWN_CODE ->
            if (h.row < GRID_ROWS - 1) return Hero(h.row+1, h.col)
        UP_CODE ->
            if (h.row > 0) return Hero(h.row-1, h.col)
    }
    return h
}