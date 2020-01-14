package rmd.imgs.game.ai

import rmd.imgs.game.ai.actions.Action
import rmd.imgs.game.objects.living.NPC

open class AI {

    fun tick(
        t: Long,
        me: NPC
    ): List<Action> {
        throw UnsupportedOperationException()
    }
}