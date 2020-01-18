package rmd.imgs.game.objects

import rmd.imgs.game.datastruct.Position

open class GameObject(
    protected var pos: Position
) {

    protected var skin: Int = 0

    fun draw() {
        throw NotImplementedError("GameObject doesn't know how to draw itself. Subclasses do.")
    }

    fun getPosition(): Position {
        return pos
    }
}