package rmd.imgs.game.surface

import kotlin.math.min

class Map<T> {
    private var map: MutableList<MutableList<T?>>
    private val width: Int
    private val height: Int

    constructor(width: Int, height: Int, default: T? = null) {
        map = IntRange(1, height)
            .toList()
            .map { IntRange(1, width).toList() }
            .map { it.map { default } }
            .map { it.toMutableList() }
            .toMutableList()
        this.width = width
        this.height = height
    }

    operator fun set(x: Int, y: Int, value: T?) {
        map[y][x] = value
    }

    operator fun get(x: Int, y: Int): T? {
        return map[y][x]
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