import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

fun drawGame(cv: Canvas, h: Hero) {
    cv.erase()
    drawGrid(cv)
    drawHero(cv, h)
}

const val SPRITE_SIZE = 64

fun drawHero(cv: Canvas, h: Hero) {
    val x = h.col * GRID_SIZE
    val y = h.row * GRID_SIZE
    cv.drawImage("Hero|0,0,$SPRITE_SIZE,$SPRITE_SIZE",x,y,GRID_SIZE,GRID_SIZE)
}

fun drawGrid(cv: Canvas) {
    for(x in 0..cv.width step GRID_SIZE)
        cv.drawLine(x,0,x,cv.height, WHITE, 1)
    for(y in 0..cv.height step GRID_SIZE)
        cv.drawLine(0,y,cv.width,y, WHITE, 1)
}