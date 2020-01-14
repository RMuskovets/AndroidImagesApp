package rmd.imgs.game.objects.living

import rmd.imgs.game.ai.AI
import rmd.imgs.game.objects.LivingObject
import rmd.imgs.game.objects.features.CanAttack
import rmd.imgs.game.objects.features.HasDamage
import rmd.imgs.game.objects.features.HasExperience
import rmd.imgs.game.objects.types.Fraction

class NPC(
    val _fraction: Fraction,
    var ai: AI
): LivingObject(), CanAttack, HasDamage, HasExperience {

    private var _health = 100

    private var xp = 0
    private var lvl = 1
    private var damage = 5

    override fun getHealth(): Int {
        return _health
    }

    override fun getFraction(): Fraction {
        return _fraction
    }

    override fun die() {

    }

    override fun attack() {

    }

    override fun getDamage(): Int {
        return damage
    }

    override fun getXP(): Int {
        return xp
    }

    override fun getLevel(): Int {
        return lvl
    }

    override fun tick(t: Long) {
        draw()
        ai.tick(t, this)
    }

}