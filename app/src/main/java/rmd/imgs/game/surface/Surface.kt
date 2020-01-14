package rmd.imgs.game.surface

class Surface(
    private val width: Int,
    private val height: Int
) {
    private val surfaceMap = Map(width, height, 0)
    private val objectsMap = Map(width, height, 0)
}