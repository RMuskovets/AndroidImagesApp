package rmd.imgs.game.other

import android.graphics.Rect

object Camera {
    fun calculateViewport(
        cx: Int, cy: Int,
        worldWidth: Int, worldHeight: Int,
        cameraWidth: Int, cameraHeight: Int): Rect {

        var left = cx - (cameraWidth / 2)
        var right= cx + (cameraWidth / 2)

        var bottom=cy + (cameraHeight/ 2)
        var top   =cy - (cameraHeight/ 2)

        if (left < 0) left = 0
        if (right> worldWidth) right = worldWidth

        if (top   < 0) top = 0
        if (bottom> worldHeight) bottom = worldHeight

        return Rect(left, top, right, bottom)
    }
}