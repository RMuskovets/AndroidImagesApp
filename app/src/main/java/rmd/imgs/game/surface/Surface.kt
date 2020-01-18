package rmd.imgs.game.surface

import rmd.imgs.game.datastruct.Position
import rmd.imgs.game.objects.GameObject

class Surface(
    val id: Int,
    val width: Int,
    val height: Int
) {
    private val surfaceMap = Map(width, height, 0)
    private val objectsMap = Map<GameObject?>(width, height, null)

    private val objects = mutableListOf<GameObject>()

    fun addObject(obj: GameObject): Int {
        objects.add(obj)
        objectsMap[obj.getPosition()] = obj
        return objects.size - 1
    }

    fun setSurface(pos: Position, type: Int) {
        surfaceMap[pos] = type
    }

    fun removeObject(id: Int) {
        val obj = objects[id]
        objectsMap[obj.getPosition()] = null
        objects.removeAt(id)
    }
}