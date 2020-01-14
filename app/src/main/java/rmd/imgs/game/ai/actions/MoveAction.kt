package rmd.imgs.game.ai.actions

import rmd.imgs.game.datastruct.Position

data class MoveAction(
    val offset: Position
): Action()