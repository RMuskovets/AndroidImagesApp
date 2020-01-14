package rmd.imgs.game.objects

import rmd.imgs.game.datastruct.Position
import rmd.imgs.game.objects.features.*

abstract class LivingObject(
    pos: Position = Position(0, 0)
):
    GameObject(pos), TickListener,
    HasHealth,
    HasFraction,
    CanMove,
    CanDie
{
    override fun move(offset: Position) {
        pos += offset
    }
}