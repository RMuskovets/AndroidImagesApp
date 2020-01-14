package rmd.imgs.game.objects

import rmd.imgs.game.objects.types.EffectType

data class Effect(
    val type: EffectType,
    val time: Int,
    val strength: Int
)