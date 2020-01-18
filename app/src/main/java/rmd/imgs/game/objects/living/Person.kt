package rmd.imgs.game.objects.living

import rmd.imgs.game.objects.LivingObject
import rmd.imgs.game.objects.features.HasDamage
import rmd.imgs.game.objects.features.HasExperience

abstract class Person: LivingObject(), HasDamage, HasExperience {

    private var _health: Int = 100

    private var _xp: Int = 0
    private var _lvl: Int = 1

    override fun getHealth(): Int {
        return _health
    }

    override fun damage(dmg: Int) {
        if (_health <= dmg)
            die()
        _health -= if (_health >= dmg) dmg else 0
    }

    override fun getXP(): Int {
        return _xp
    }

    override fun getLevel(): Int {
        return _lvl
    }

    override fun addXP(xp: Int) {
        _xp += xp
        recalcLevel()
    }

    override fun getDamage(): Int {
        return getLevel() * 5
    }

    private fun recalcLevel() {
        while (true) {
            val xpNextLvl = 2 shr _lvl+1
            val xpThisLvl = 2 shr _lvl
            if (_xp > (xpNextLvl - xpThisLvl)) {
                _lvl++
                _xp -= (xpNextLvl - xpThisLvl)
            } else break
        }
    }
}