package rmd.imgs.game.objects.types

data class Fraction(
    val id: Int,
    val name: String
) {
    companion object {
        val FRACTIONS = mutableListOf(
            Fraction(0, "Players"),
            Fraction(1, "Enemies"),
            Fraction(2, "Neutral")
        )
    }

    override operator fun equals(other: Any?): Boolean {
        if (other !is Fraction) return false
        if (other.id != id) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "$name ($id)"
    }
}