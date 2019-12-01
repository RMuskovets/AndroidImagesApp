package rmd.imgs.game

import rmd.imgs.R

class TileType(
    val walkable: Boolean,

    val imageRes: Int
) {

    companion object {

        private val TYPES = arrayOf(
            TileType(true, R.drawable.grass),
            TileType(true, R.drawable.sand)
        )

        fun getTileType(num: Int): TileType {
            return TYPES[num]
        }
    }
}