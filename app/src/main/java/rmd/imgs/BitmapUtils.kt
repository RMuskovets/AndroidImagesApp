package rmd.imgs

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

object BitmapUtils {

    fun overlay(a: Bitmap, b: Bitmap): Bitmap {
        var bg = a
        if (!a.isMutable) bg = a.copy(Bitmap.Config.ARGB_8888, true)
        val cvs = Canvas(bg)
        val p = Paint(Paint.FILTER_BITMAP_FLAG)
        cvs.drawBitmap(b, 0.0f, 0.0f, p)
        return a
    }
}