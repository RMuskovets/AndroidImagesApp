package rmd.imgs.game.objects

import rmd.imgs.game.datastruct.Position

open class GameObject(
    private var pos: Position
) {

    private var skin: Int = 0

    fun draw() {
        throw NotImplementedError("GameObject doesn't know how to draw itself. Subclasses do.")
    }
}