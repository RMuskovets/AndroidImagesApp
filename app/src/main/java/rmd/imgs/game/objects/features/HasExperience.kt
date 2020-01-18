package rmd.imgs.game.objects.features

interface HasExperience {

    fun getXP(): Int
    fun getLevel(): Int
    fun addXP(xp: Int)
}