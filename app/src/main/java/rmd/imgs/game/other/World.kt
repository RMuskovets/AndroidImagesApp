package rmd.imgs.game.other

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import rmd.imgs.R
import rmd.imgs.game.objects.Player

class World(
    private val ctx: Context,

    private val width: Int,
    private val height:Int,
    private val camwdt:Int = width,
    private val camhgt:Int = height,

    var scrwdt:Int = 0,
    var scrhgt:Int = 0
): IWorld {
    private var camx = width/2
    private var camy = height/2

    private val startMap = listOf(
        0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 4, 1, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 4, 1, 1, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 4, 4, 4, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 3, 4, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        0, 2, 3, 4, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 4, 1, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 4, 1, 1, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 4, 4, 4, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 3, 4, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        0, 2, 3, 4, 1, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0
    )

    private var grid = MutableList(width*height) {
        TileType.getTileType(startMap[it%startMap.size])
    }

    private val plr: Player = Player(
        camx,
        camy,
        camwdt,
        camhgt,
        R.drawable.player
    )

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
                    BitmapFactory.decodeResource(ctx.resources, img.imageRes),
                    pos[0],
                    pos[1],
                    Paint(Paint.FILTER_BITMAP_FLAG)
                )
            }
        }

        plr.draw(ctx, cvs, offx, offy)
    }

    override fun setTile(x: Int, y: Int, typ: Int) {
        grid[y*width+x] = TileType.getTileType(typ)
    }

    companion object {
        const val TILE_WIDTH = 16
        const val TILE_HEIGHT= 16
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

        Log.v("rmd.imgs.World", "left: $left, right: $right, top: $top, bottom: $bottom")

        return listOf(
            left, top,
            right, bottom,

            camx, camy
        )
    }
}