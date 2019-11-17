package rmd.imgs

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class World(
    private val ctx: Context,

    private val width: Int,
    private val height:Int,
    private val camwdt:Int,
    private val camhgt:Int,

    var scrwdt:Int = 0,
    var scrhgt:Int = 0
) {
    private var camx = 0
    private var camy = 0

    private var grid = MutableList(width*height) {
        R.drawable.grass
    }

    fun draw(cvs: Canvas) {
        for (x in IntRange(0, width - 1)) {
            for (y in IntRange(0, height - 1)) {
                val img = grid[y * width + x]
                cvs.drawBitmap(
                    BitmapFactory.decodeResource(ctx.resources, img),
                    (x * TILE_WIDTH * 2).toFloat(),
                    (y *TILE_HEIGHT * 2).toFloat(),
                    Paint(Paint.FILTER_BITMAP_FLAG)
                )
            }
        }
    }

    fun setTile(x: Int, y: Int, img: Int) {
        grid[y*width+x] = img
    }

    companion object {
        const val TILE_WIDTH = 16
        const val TILE_HEIGHT= 16
    }
}