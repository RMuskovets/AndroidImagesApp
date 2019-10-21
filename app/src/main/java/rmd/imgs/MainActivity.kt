package rmd.imgs

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var grid: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        grid = findViewById(R.id.gridview)
        Async().execute("http://placehold.it/128x128", grid, this as Context)
    }

    class Async : AsyncTask<Any, Int, Bitmap>() {

        @SuppressLint("StaticFieldLeak")
        private lateinit var grid: GridView
        @SuppressLint("StaticFieldLeak")
        private lateinit var ctx: Context

        private fun url2bitmap(imgurl: String): Bitmap {
            val res: Bitmap
            val url: URL? = URL(imgurl)
            res = BitmapFactory.decodeStream(url?.openStream())
            return res
        }

        override fun doInBackground(vararg args: Any): Bitmap {
            val url = args[0] as String
            grid = args[1] as GridView
            ctx = args[2] as Context
            return url2bitmap(url)
        }

        override fun onPostExecute(result: Bitmap) {
            val bitmaps = List(ctx.resources.getInteger(R.integer.tbl_sz_w) * ctx.resources.getInteger(R.integer.tbl_sz_h)) { BitmapDrawable(result) }
            grid.adapter = ImageAdapter(ctx, bitmaps)
        }
    }
}
