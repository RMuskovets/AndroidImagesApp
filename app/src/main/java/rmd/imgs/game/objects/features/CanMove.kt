package rmd.imgs.game.objects.features

import rmd.imgs.game.datastruct.Position

interface CanMove {
    fun move(offset: Position)
}