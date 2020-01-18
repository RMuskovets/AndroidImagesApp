package rmd.imgs.game.objects.living

import rmd.imgs.game.objects.types.Fraction

class Player: Person() {

    override fun tick(t: Long) {

    }

    override fun getFraction(): Fraction {
        return Fraction.FRACTIONS.filter { it.name == "Players" }[0]
    }

    override fun die() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}