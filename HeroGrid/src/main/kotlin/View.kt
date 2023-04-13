import pt.isel.canvas.*

/**
 * Draws all game arena.
 * Before drawing the arena, it erases the canvas.
 * @receiver the canvas to draw on
 * @param game the game to be drawn
 */
fun Canvas.drawGame(game: Game) {
    erase()
    drawGrid()
    drawHero(game.hero)
    drawRobot(game.robot)
}

/**
 * Square side of the sprite image
 */
const val SPRITE_SIZE = 64

fun Canvas.drawRobot(r: Actor) = drawActor(r,"robot")
fun Canvas.drawHero(h: Actor) = drawActor(h,"Hero")

/**
 * Draws the hero on the canvas displaying the sprite that corresponds to the hero's direction and walk.
 * @receiver the canvas to draw on
 * @param actor the hero to be drawn
 */
fun Canvas.drawActor(actor: Actor, file: String) {
    val part = actor.walk.ordinal * GRID_SIZE / 4
    val x = actor.pos.col * GRID_SIZE + part * actor.dir.dCol // x coordinate of the hero in the canvas
    val y = actor.pos.row * GRID_SIZE + part * actor.dir.dRow // y coordinate of the hero in the canvas
    val ySprite = actor.dir.ordinal * SPRITE_SIZE  // y coordinate of the sprite in the image
    val xSprite = SPRITE_SIZE * actor.walk.ordinal // x coordinate of the sprite in the image
    drawImage("$file|$xSprite,$ySprite,$SPRITE_SIZE,$SPRITE_SIZE",x,y,GRID_SIZE,GRID_SIZE)
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