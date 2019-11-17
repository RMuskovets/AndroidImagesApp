package rmd.imgs
//
//import android.app.Activity
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.graphics.Canvas
//import android.graphics.drawable.BitmapDrawable
//import android.graphics.drawable.Drawable
//import android.view.View
//import android.view.ViewGroup
//import android.widget.*
//import kotlin.random.Random
//
//class ImageAdapter(
//    private var ctx: Activity,
//    private var imgs: MutableList<Image>,
//    private var plrx: Int, private var plry: Int,
//    private var width: Int, private var height: Int) : BaseAdapter() {
//
//    private var parent: GridView = ctx.findViewById(R.id.gridview)
//
//    init {
//        parent.numColumns = width
//    }
//
//    override fun getItemId(p: Int): Long {
//        return 0
//    }
//
//    override fun getCount(): Int {
//        return width*height
//    }
//    operator fun get(index: Int): Bitmap? {
//        return imgs[index].img
//    }
//
//    override fun getItem(pos: Int): Any {
//        return imgs[pos]
//    }
//
//    override fun getView(pos: Int, convertView: View?, parent: ViewGroup): View {
//        println(plrx)
//        println(plry)
//        @Suppress("USELESS_ELVIS")
//        val iv = (convertView as ImageView?)?:ImageView(ctx)
//        iv.layoutParams = AbsListView.LayoutParams(16, 16)
//        iv.scaleType = ImageView.ScaleType.CENTER_CROP
//        if (pos < imgs.size) {
//            if (((plrx-1) + (plry-1) * width) != pos) {
//                iv.setImageBitmap(imgs[pos].img!!)
//            } else {
//                iv.setImageBitmap(BitmapUtils.overlay(
//                    imgs[pos].img!!,
//                    BitmapFactory.decodeResource(ctx.resources, R.drawable.player)
//                    ))
//            }
//        }
//        return iv
//    }
//
//    fun refresh() {
//        this.notifyDataSetChanged()
//    }
//
//    fun onplrmove(nx: Int, ny: Int) {
//        plrx = nx
//        plry = ny
//
//        refresh()
//    }
//}
//
