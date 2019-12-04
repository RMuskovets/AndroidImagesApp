package rmd.imgs.game

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Player(
    private var x: Int,
    private var y: Int,
    private var camWidth: Int,
    private var camHeight: Int,
    private val skin: Int
) {
    fun draw(ctx: Context, cvs: Canvas, offx: Int, offy: Int) {
        cvs.drawBitmap(
            BitmapFactory.decodeResource(ctx.resources, skin),
            (offx + (x * World.TILE_WIDTH)).toFloat(),
            (offy + (y * World.TILE_HEIGHT)).toFloat(),
            Paint(Paint.FILTER_BITMAP_FLAG)
        )
    }
}