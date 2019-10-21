package rmd.imgs

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ImageAdapter(private var ctx: Context, private var imgs: List<Drawable>) : BaseAdapter() {
    override fun getItemId(p: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return ctx.resources.getInteger(R.integer.tbl_sz_w) * ctx.resources.getInteger(R.integer.tbl_sz_h)
    }
    operator fun get(index: Int): Drawable {
        return imgs[index]
    }

    override fun getItem(pos: Int): Any {
        return imgs[pos]
    }

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup): View {
        @Suppress("USELESS_ELVIS")
        val img = (convertView as ImageView?)?:ImageView(ctx)
        img.layoutParams = AbsListView.LayoutParams(128, 128)
        img.scaleType = ImageView.ScaleType.CENTER_CROP
        img.setImageDrawable(imgs[pos])

        return img
    }
}