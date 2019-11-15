package rmd.imgs

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlin.random.Random

class ImageAdapter(private var ctx: Activity, private var imgs: MutableList<Image>) : BaseAdapter() {

    private var parent: ViewGroup = ctx.findViewById(R.id.gridview)

    override fun getItemId(p: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return ctx.resources.getInteger(R.integer.tbl_sz_w) * ctx.resources.getInteger(R.integer.tbl_sz_h)
    }
    operator fun get(index: Int): Drawable {
        return imgs[index].img
    }

    override fun getItem(pos: Int): Any {
        return imgs[pos]
    }

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup): View {
        @Suppress("USELESS_ELVIS")
        val img = (convertView as ImageView?)?:ImageView(ctx)
        img.layoutParams = AbsListView.LayoutParams(128, 128)
        img.scaleType = ImageView.ScaleType.CENTER_CROP
        if (imgs[pos].isShown) {
            img.setImageDrawable(imgs[pos].img)
        } else {
            img.setImageDrawable(null)
        }
        return img
    }

    fun random() {
        val pos = Random.nextInt(count)
        for (i in IntRange(0, imgs.size-1)) {
            imgs[i] = Image(imgs[i].img, pos == i)
        }
        refresh()
    }

    private fun refresh() {
//        try {
//            parent.invalidate()
//        } catch (e: Throwable) {
//            parent.postInvalidate()
//        }
        this.notifyDataSetChanged()
    }
}

