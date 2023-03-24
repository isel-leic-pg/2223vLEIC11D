import pt.isel.canvas.*

/**
 * Dimensions of the grid
 */
const val GRID_SIZE = 64    // Side of the grid square
const val GRID_ROWS = 10    // Number of rows in the grid
const val GRID_COLS = 16    // Number of columns in the grid

/**
 * Main function of the game.
 */
fun main() {
    onStart {
        val arena = Canvas(GRID_SIZE*GRID_COLS, GRID_SIZE*GRID_ROWS, BLACK)
        var hero = Hero(GRID_ROWS/2, GRID_COLS/2)
        drawGame(arena,hero)
        arena.onKeyPressed { key ->
            hero = moveHero(key.code, hero)
            drawGame(arena,hero)
        }
    }
    onFinish {  }
}


