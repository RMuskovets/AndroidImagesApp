package rmd.imgs.game.objects

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import rmd.imgs.game.other.World

class Player(
    private var x: Int,
    private var y: Int,
    val camWidth: Int,
    val camHeight: Int,
    private var skin: Int
) {
    private var hp = 100
    private var lvl = 1
    private var lvlxp = 0

    fun draw(ctx: Context, cvs: Canvas, offx: Int, offy: Int) {
        cvs.drawBitmap(
            BitmapFactory.decodeResource(ctx.resources, skin),
            (offx + (x * World.TILE_WIDTH * 2)).toFloat(),
            (offy + (y * World.TILE_HEIGHT * 2)).toFloat(),
            Paint(Paint.FILTER_BITMAP_FLAG)
        )
    }
    fun updateSkin(skin: Int) {
        this.skin = skin
    }

    fun damage(dmg: Int): Int {
        hp -= dmg
        if (hp < 0) hp = 0
        return hp
    }
    fun heal(hp: Int): Int {
        this.hp += hp
        if (this.hp > 100) this.hp = 100
        return this.hp
    }

    fun calculateRemXP(): Int {
        return 0
    }
}