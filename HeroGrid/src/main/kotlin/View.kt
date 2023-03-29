import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

/**
 * Draws all game arena.
 * Before drawing the arena, it erases the canvas.
 * @receiver the canvas to draw on
 * @param h the hero to be drawn
 */
fun Canvas.drawGame(h: Hero) {
    erase()
    drawGrid()
    drawHero(h)
}

/**
 * Square side of the sprite image
 */
const val SPRITE_SIZE = 64

/**
 * Draws the hero in the canvas
 * @receiver the canvas to draw on
 * @param h the hero to be drawn
 */
fun Canvas.drawHero(h: Hero) {
    val x = h.pos.col * GRID_SIZE
    val y = h.pos.row * GRID_SIZE
    val ySprite = h.dir.ordinal * SPRITE_SIZE
    drawImage("Hero|0,$ySprite,$SPRITE_SIZE,$SPRITE_SIZE",x,y,GRID_SIZE,GRID_SIZE)
}

/**
 * Draws the grid in the canvas
 * @receiver the canvas to draw on
 */
fun Canvas.drawGrid() {
    for(x in 0..width step GRID_SIZE)
        drawLine(x,0,x,height, WHITE, 1)
    for(y in 0..height step GRID_SIZE)
        drawLine(0,y,width,y, WHITE, 1)
}