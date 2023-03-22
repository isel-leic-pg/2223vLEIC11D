import pt.isel.canvas.*

fun main() {
    onStart {
        val canvas = Canvas(600,400, BLUE)
        canvas.drawCircle(50,50,25,RED)
        canvas.drawCircle(200,100,100, BLACK, 10)
        canvas.drawLine(0,100,300,100, GREEN,5)
        canvas.drawRect(100,0,100,100, YELLOW)
        canvas.drawImage("Hero",0,0,300,300)
        canvas.drawImage("Hero|128,0,64,64",300,200,400,200)
    }
    onFinish { }
}

