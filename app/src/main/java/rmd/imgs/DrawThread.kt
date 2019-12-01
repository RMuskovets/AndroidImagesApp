package rmd.imgs

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder
import rmd.imgs.game.World
import rmd.imgs.logging.Logger

class DrawThread(
    private val ctx: Context,
    private val log: Logger,
    private val sh: SurfaceHolder
): Thread() {

    var running: Boolean = false

    private var lastTime: Long = 0

    override fun run() {
        val world = World(
            ctx, log,
            16, 16,
            16, 16
        )

        var cvs: Canvas?

        while (running) {
            val now = System.currentTimeMillis()
            @Suppress("UNUSED_VARIABLE")
            var elt = now - lastTime

            cvs = null
            try {
                cvs = sh.lockCanvas()
                synchronized(sh) {

                    world.scrwdt = cvs.width
                    world.scrhgt = cvs.height

                    println(cvs.width)
                    println(cvs.height)

                    cvs.drawColor(Color.BLACK)
                    world.draw(cvs)
                }
            } finally {
                @Suppress("SENSELESS_COMPARISON")
                if (cvs != null) {
                    sh.unlockCanvasAndPost(cvs)
                }
            }
        }
    }
}