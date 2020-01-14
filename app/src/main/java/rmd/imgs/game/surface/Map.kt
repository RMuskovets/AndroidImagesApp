package rmd.imgs.game.surface

import rmd.imgs.game.datastruct.Position
import kotlin.math.min

class Map<T>(private val width: Int, private val height: Int, default: T? = null) {
    private var map = IntRange(1, height)
        .toList()
        .map { IntRange(1, width).toList() }
        .map { it.map { default } }
        .map { it.toMutableList() }
        .toMutableList()

    operator fun set(x: Int, y: Int, value: T?) {
        map[y][x] = value
    }
    operator fun set(p: Position, value: T?) {
        map[p.y][p.x] = value
    }

    operator fun get(x: Int, y: Int): T? {
        return map[y][x]
    }
    operator fun get(p: Position): T? {
        return map[p.y][p.x]
    }

    fun expand(newWidth: Int, newHeight: Int): Map<T> {
        val newMap = Map<T>(newWidth, newHeight)
        for (x in IntRange(1, min(width, newWidth))) {
            for (y in IntRange(1, min(height, newHeight))) {
                newMap[x-1, y-1] = map[y-1][x-1]
            }
        }
        return newMap
    }
}