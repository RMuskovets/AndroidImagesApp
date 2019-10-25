package rmd.imgs

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.GridView
import androidx.core.os.postDelayed
import java.net.URL
import java.util.*
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {

    private lateinit var grid: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        grid = findViewById(R.id.gridview)
        Async().execute("http://placehold.it/128x128", grid, this as Activity)
    }

    class Async : AsyncTask<Any, Int, Bitmap>() {

        @SuppressLint("StaticFieldLeak")
        private lateinit var grid: GridView
        @SuppressLint("StaticFieldLeak")
        private lateinit var ctx: Activity

        private fun url2bitmap(imgurl: String): Bitmap {
            val res: Bitmap
            val url: URL? = URL(imgurl)
            res = BitmapFactory.decodeStream(url?.openStream())
            return res
        }

        override fun doInBackground(vararg args: Any): Bitmap {
            val url = args[0] as String
            grid = args[1] as GridView
            ctx = args[2] as Activity
            return url2bitmap(url)
        }

        override fun onPostExecute(result: Bitmap) {
            val bitmaps = List(ctx.resources.getInteger(R.integer.tbl_sz_w) * ctx.resources.getInteger(R.integer.tbl_sz_h)) { BitmapDrawable(result) }
            val adapter = ImageAdapter(ctx, bitmaps.map { Image(it, true) }.toMutableList())
            grid.adapter = adapter

            val h = Handler()

            var r = Runnable {}

            r = Runnable {
                adapter.random()
                h.postDelayed(r, 1000)
            }

            h.post(r)
        }
    }
}
