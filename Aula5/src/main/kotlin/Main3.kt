import pt.isel.canvas.*

const val START_X = -SPRITE_SIZE/4

fun main(){
    onStart {
        val cv = Canvas(800,600)
        var x = START_X
        val y = cv.height/2-HERO_SIZE/2
        cv.onTimeProgress(25) {
            cv.erase()  //cv.drawRect(x,y,HERO_SIZE,HERO_SIZE, WHITE)
            x += 10
            drawHero(cv,x,y)
            if (x > cv.width)
                x = START_X
        }
    }
    onFinish {  }
}