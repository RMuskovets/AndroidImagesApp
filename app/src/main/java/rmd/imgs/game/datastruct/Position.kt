package rmd.imgs.game.datastruct

data class Position(
    val x: Int,
    val y: Int
) {
    operator fun plus(pos: Position): Position {
        return Position(x + pos.x, y + pos.y)
    }

    operator fun unaryMinus(): Position {
        return Position(-x, -y)
    }

    operator fun minus(pos: Position): Position {
        return this + -pos
    }

    operator fun times(n: Int): Position {
        return Position(x * n, y * n)
    }

    operator fun times(pos: Position): Position {
        return Position(x * pos.x, y * pos.y)
    }

    operator fun get(i: Int): Int {
        return when(i) {
            0 -> x
            1 -> y
            else -> throw IllegalArgumentException("index must be 0 or 1")
        }
    }
}