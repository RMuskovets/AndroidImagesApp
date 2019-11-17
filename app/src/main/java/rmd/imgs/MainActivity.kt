package rmd.imgs

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {

        const val MAP_WIDTH = 8
        const val MAP_HEIGHT= 8

        val MAP = intArrayOf(
            1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 3, 2, 2, 1, 1, 1,
            1, 1, 1, 2, 2, 1, 1, 1,
            1, 1, 1, 2, 2, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1
        )

        val SPRITES = intArrayOf(
            R.drawable.grass,
            R.drawable.water,
            R.drawable.tree
        )
    }

    private lateinit var grid: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(GameView(
            this
        ))
    }
}
