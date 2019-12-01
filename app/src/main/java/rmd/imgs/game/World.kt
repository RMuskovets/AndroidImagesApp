package rmd.imgs.game

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import rmd.imgs.R
import rmd.imgs.logging.Logger
import kotlin.random.Random

class World(
    private val ctx: Context,
    private val log: Logger,

    private val width: Int,
    private val height:Int,
    private val camwdt:Int = width,
    private val camhgt:Int = height,

    var scrwdt:Int = 0,
    var scrhgt:Int = 0
): IWorld {
    private var camx = width / 2
    private var camy = height/ 2

    private var grid = MutableList(width*height) {
        IMAGES[Random.nextInt(IMAGES.size)]
    }

    private fun calcOffset(rng: List<Int>): List<Int> {
        return listOf(
            (scrwdt / 2 - (rng[0] - rng[3]) * TILE_WIDTH / 2) / 4,
            (scrhgt / 2 - (rng[1] - rng[2]) * TILE_HEIGHT / 2) / 4
        )
    }

    private fun calcPos(offx: Int, offy: Int, x: Int, y: Int): List<Float> {
        return listOf(
            offx + (x * TILE_WIDTH * 2).toFloat(),
            offy + (y * TILE_HEIGHT * 2).toFloat()
        )
    }

    override fun draw(cvs: Canvas) {
        val rng = cameraPos()

        val off = calcOffset(rng)
        val offx= off[0]
        val offy= off[1]

        for (x in IntRange(rng[0], rng[3] - 1)) {
            for (y in IntRange(rng[1], rng[2] - 1)) {
                val img = grid[y * width + x]
                val pos = calcPos(offx, offy, x, y)
                cvs.drawBitmap(
                    BitmapFactory.decodeResource(ctx.resources, img),
                    pos[0],
                    pos[1],
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

    override fun setTile(x: Int, y: Int, typ: Int) {
        grid[y*width+x] = typ
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


        log.debug("left: $left, right: $right, top: $top, bottom: $bottom")

        return listOf(
            left, top,
            right, bottom,

            camx, camy
        )
    }
}