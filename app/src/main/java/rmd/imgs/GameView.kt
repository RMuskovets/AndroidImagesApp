package rmd.imgs

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(
    private val ctx: Context
): SurfaceView(ctx), SurfaceHolder.Callback {

    private lateinit var drw: DrawThread

    init {
        holder.addCallback(this)
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        var retry = true
        drw.running = false
        while (retry) {
            try {
                drw.join()
                retry = false
            } catch (e: InterruptedException) { }
        }
    }

    override fun surfaceCreated(p0: SurfaceHolder?) {
        drw = DrawThread(
            ctx,
            holder
        )
        drw.running = true
        drw.start()
    }
}