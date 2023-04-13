import pt.isel.canvas.*
import Direction.*

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
        val arena = Canvas(GRID_SIZE*GRID_COLS+1, GRID_SIZE*GRID_ROWS+1, YELLOW)
        var game = createGame()
        arena.onKeyPressed { key ->
            val dir = keyToDir(key.code)
            if (dir!=null) {
                game = game.move(dir)
                arena.drawGame(game)
            }
        }
        arena.onTimeProgress(250) {
            game = game.step()
            arena.drawGame(game)
        }
    }
    onFinish {  }
}

/**
 * Converts a key code to a direction.
 * @param keyCode the key code to be converted
 * @return the direction corresponding to the key code or null if the key code is not a direction
 */
private fun keyToDir(keyCode: Int): Direction? = when (keyCode) {
    DOWN_CODE -> DOWN
    LEFT_CODE -> LEFT
    RIGHT_CODE -> RIGHT
    UP_CODE -> UP
    else -> null
}


