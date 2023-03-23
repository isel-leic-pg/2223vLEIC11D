import pt.isel.canvas.*

const val GRID_SIZE = 64
const val GRID_ROWS = 10
const val GRID_COLS = 16

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


