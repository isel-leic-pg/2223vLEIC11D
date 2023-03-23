import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE
import pt.isel.canvas.UP_CODE

data class Hero(val row: Int, val col: Int)

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