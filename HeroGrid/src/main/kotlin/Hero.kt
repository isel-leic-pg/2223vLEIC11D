/**
 * Represents the hero in arena
 * @property pos the hero position in the grid
 * @property dir the direction the hero is facing
 */
data class Hero(val pos: Position, val dir: Direction)
/*
fun Hero.toString(): String = "Hero(pos=pos, dir=dir)"
fun Hero.copy(pos: Position =this.pos, dir: Direction =this.dir) = Hero(pos,dir)
*/

/**
 * Move the hero after turning to the given direction.
 * @receiver the hero to be moved
 * @param to the direction to move
 * @return the new hero after the move
 */
fun Hero.move(to: Direction): Hero = face(to).moveFaced() //moveFaced(face(this,to))

/**
 * Move the hero in the direction it is facing.
 * @receiver the hero to be moved
 * @return the new hero after the move
 */
fun Hero.moveFaced(): Hero {
    val pos = pos + dir
    return if (pos.isValid()) copy(pos= pos) else this
}

/**
 * Turn the hero to the given direction.
 * @receiver the hero to be turned
 * @param to the direction to turn
 * @return the new hero after the turn
 */
fun Hero.face(to: Direction) = copy(dir= to)








