import pt.isel.canvas.*

const val SPRITE_SIZE = 64
const val HERO_SIZE = 128

fun drawHero(c: Canvas, x: Int, y: Int) {
    val xSprite = 2 * SPRITE_SIZE
    c.drawImage("Hero|0,$xSprite,$SPRITE_SIZE,$SPRITE_SIZE",x,y,HERO_SIZE,HERO_SIZE)
}

fun main(){
    onStart {
        val cv = Canvas(800,600)
        val x = -SPRITE_SIZE/4
        val y = cv.height/2-HERO_SIZE/2

        for(f in 0 until 100)
            drawHero(cv,x+f*10,y)

    }
    onFinish {  }
}