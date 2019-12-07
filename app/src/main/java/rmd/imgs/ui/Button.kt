package rmd.imgs.ui

import android.content.res.Resources
import android.graphics.*

class Button(
    private val isRound: Boolean,
    private var image: Int,
    private var bordercolor: Int,
    private var width: Int,
    private var height: Int
) {
    var eventListeners: List<() -> Unit> = listOf()
        private set
    fun addOnclick(fn: () -> Unit) {
        val mut = eventListeners.toMutableList()
        mut.add(fn)
        eventListeners = mut.toList()
    }

    fun onclick() {
        eventListeners.forEach { it() }
    }

    fun draw(res: Resources, cvs: Canvas, x: Int, y: Int) {
        cvs.drawColor(bordercolor)
        if (isRound)
        cvs.drawOval(
            x.toFloat(), y.toFloat(),
            width.toFloat(), height.toFloat(),
            Paint(Paint.ANTI_ALIAS_FLAG)
        )
        else
        cvs.drawRect(
            x.toFloat(), y.toFloat(),
            width.toFloat(), height.toFloat(),
            Paint(Paint.ANTI_ALIAS_FLAG)
        )
        val img = BitmapFactory.decodeResource(res, image)
        cvs.drawBitmap(
            img,
            x + width.toFloat() / 2 - img.width / 2,
            y + height.toFloat() / 2 - img.height / 2,
            Paint(Paint.ANTI_ALIAS_FLAG)
        )
    }
}