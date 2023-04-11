import pt.isel.canvas.*

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
 * Draws the hero on the canvas displaying the sprite that corresponds to the hero's direction and walk.
 * @receiver the canvas to draw on
 * @param h the hero to be drawn
 */
fun Canvas.drawHero(h: Hero) {
    val x = h.pos.col * GRID_SIZE +  // x coordinate of the hero in the canvas
        h.walk.ordinal * GRID_SIZE/4 * h.dir.dCol
    val y = h.pos.row * GRID_SIZE +  // y coordinate of the hero in the canvas
        h.walk.ordinal * GRID_SIZE/4 * h.dir.dRow
    val ySprite = h.dir.ordinal * SPRITE_SIZE  // y coordinate of the sprite in the image
    val xSprite = SPRITE_SIZE * h.walk.ordinal // x coordinate of the sprite in the image
    drawImage("Hero|$xSprite,$ySprite,$SPRITE_SIZE,$SPRITE_SIZE",x,y,GRID_SIZE,GRID_SIZE)
}

/**
 * Draws the grid in the canvas
 * @receiver the canvas to draw on
 */
fun Canvas.drawGrid() {
    for(x in 0..width step GRID_SIZE)
        drawLine(x,0,x,height, RED, 1)
    for(y in 0..height step GRID_SIZE)
        drawLine(0,y,width,y, RED, 1)
}