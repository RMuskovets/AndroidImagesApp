package rmd.imgs.game.other

import android.graphics.Canvas

interface IWorld {

    fun setTile(x: Int, y: Int, typ: Int)
    fun draw(cvs: Canvas)
}