package rmd.imgs

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.random.Random

class World(
    private val ctx: Context,

    private val width: Int,
    private val height:Int,
    private val camwdt:Int = width,
    private val camhgt:Int = height,

    var scrwdt:Int = 0,
    var scrhgt:Int = 0
) {
    private var camx = width / 2
    private var camy = height/ 2

    private var grid = MutableList(width*height) {
        IMAGES[Random.nextInt(IMAGES.size)]
    }

    fun draw(cvs: Canvas) {
        val rng = cameraPos()

        val offx = (scrwdt / 2 - (rng[0] - rng[3]) * TILE_WIDTH / 2) / 4
        val offy = (scrhgt / 2 - (rng[1] - rng[2]) * TILE_HEIGHT / 2) / 4

        for (x in IntRange(rng[0], rng[3] - 1)) {
            for (y in IntRange(rng[1], rng[2] - 1)) {
                val img = grid[y * width + x]
                cvs.drawBitmap(
                    BitmapFactory.decodeResource(ctx.resources, img),
                    offx + (x * TILE_WIDTH * 2).toFloat(),
                    offy + (y * TILE_HEIGHT * 2).toFloat(),
                    Paint(Paint.FILTER_BITMAP_FLAG)
                )
            }
        }

        cvs.drawBitmap(
            BitmapFactory.decodeResource(ctx.resources, R.drawable.player),
            (offx + (rng[4] * TILE_WIDTH)).toFloat(),
            (offy + (rng[5] * TILE_HEIGHT)).toFloat(),
            Paint(Paint.FILTER_BITMAP_FLAG)
        )
    }

    fun setTile(x: Int, y: Int, img: Int) {
        grid[y*width+x] = img
    }

    companion object {
        const val TILE_WIDTH = 16
        const val TILE_HEIGHT= 16

        val IMAGES = arrayOf(
            R.drawable.grass,
            R.drawable.sand,
            R.drawable.stone,
            R.drawable.tree,
            R.drawable.water
        )
    }

    private fun cameraPos(): List<Int> {
        var left  = camx - (camwdt / 2)
        var right = camx + (camwdt / 2)
        var top   = camy - (camhgt / 2)
        var bottom= camy + (camhgt / 2)

        if (left < 0) left = 0
        if (right > width) right = width

        if (top < 0) top = 0
        if (bottom > height) bottom = height

        println()
        println(left)
        println(right)
        println(top)
        println(bottom)

        return listOf(
            left, top,
            right, bottom,

            camx, camy
        )
    }
}