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
        val arena = Canvas(GRID_SIZE*GRID_COLS, GRID_SIZE*GRID_ROWS, YELLOW)
        var hero = createHero()
        arena.onKeyPressed { key ->
            val dir = keyToDir(key.code)
            if (dir!=null) {
                hero = hero.move(dir)
                arena.drawGame(hero)
            }
        }
        arena.onTimeProgress(250) {
            hero = hero.step()
            arena.drawGame(hero)
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
    DOWN_CODE -> Direction.DOWN
    LEFT_CODE -> Direction.LEFT
    RIGHT_CODE -> Direction.RIGHT
    UP_CODE -> Direction.UP
    else -> null
}


