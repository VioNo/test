package animal

abstract class Animal(
    val symbol: String,
    val name: String,
    val weight: Double,
    val maxPerCell: Int,
    val speed: Int,
    val foodRequired: Double,
    val lifespan: Int,
    val isInitialized: Boolean
) {
    var energy: Double = 100.0
    var daysAlive: Int = 0

    abstract fun eat(cell: Cell)
    abstract fun reproduce(cell: Cell): Animal?
    abstract fun move(cell: Cell, newCell: Cell)

    fun decreaseEnergy() {
        energy -= foodRequired
        if (energy <= 0) {
            energy = 0.0
        }
    }

    fun ageOneDay() {
        daysAlive++
    }

    fun shouldDie(): Boolean {
        return daysAlive >= lifespan || energy <= 0
    }
}

data class Cell(var plants: Int = 0, val animals: MutableList<Animal> = mutableListOf())