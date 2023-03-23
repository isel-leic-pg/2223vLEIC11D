import pt.isel.canvas.*

fun moveHero(cv: Canvas, x: Int, y: Int, shift: Int): Int {
    cv.erase()
    val newX = x+shift
    drawHero(cv, newX, y)
    return newX
}

fun main() {
    onStart {
        val cv = Canvas(800,600)
        val y = cv.height/2-HERO_SIZE/2
        var x = moveHero(cv,START_X,y,0)
        moveHero(cv,x,y,0)
        cv.onKeyPressed { key ->
            when (key.code) {
                RIGHT_CODE ->
                    if (x < cv.width) x = moveHero(cv,x,y,10)
                LEFT_CODE ->
                    if (x > 0) x = moveHero(cv,x,y,-10)
            }
        }
    }
    onFinish {  }
}