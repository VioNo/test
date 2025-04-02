package herbivore

import animal.*
import animal.Cell
import kotlin.random.Random

open class Herbivore(
    symbol: String,
    name: String,
    weight: Double,
    maxPerCell: Int,
    speed: Int,
    foodRequired: Double,
    lifespan: Int,
    isInitialized: Boolean
) : Animal(symbol, name, weight, maxPerCell, speed, foodRequired, lifespan, isInitialized) {

    override fun eat(cell: Cell) {
        if (cell.plants > 0 && energy < 100) {
            val plantsToEat = 1 + Random.nextInt(2)  // Может съесть 1-2 растения
            val actualEaten = plantsToEat.coerceAtMost(cell.plants)
            cell.plants -= actualEaten
            energy += actualEaten * 15.0
            energy = energy.coerceAtMost(120.0)
            println("$name съел $actualEaten растений")
        }
    }

    override fun reproduce(cell: Cell): Animal? {
        if (cell.animals.count { it.name == name } >= maxPerCell) return null
        if (Random.nextDouble() > 0.1) return null

        val partners = cell.animals.filter { it.name == name && it != this && it.energy > 40 }
        if (partners.isNotEmpty() && energy > 60) {
            println("$name размножился")
            return when (this) {
                is Horse -> Horse(lifespan, false)
                is Deer -> Deer(lifespan, false)
                is Rabbit -> Rabbit(lifespan, false)
                is Mouse -> Mouse(lifespan, false)
                is Goat -> Goat(lifespan, false)
                is Sheep -> Sheep(lifespan, false)
                is Boar -> Boar(lifespan, false)
                is Buffalo -> Buffalo(lifespan, false)
                is Duck -> Duck(lifespan, false)
                is Caterpillar -> Caterpillar(lifespan, false)
                else -> null
            }
        }
        return null
    }

    override fun move(cell: Cell, newCell: Cell) {
        if (newCell.animals.count { it.name == name } < maxPerCell) {
            cell.animals.remove(this)
            newCell.animals.add(this)
        }
    }
}




class Horse(lifespan: Int, isInitialized: Boolean) : Herbivore("🐎", "Лошадь", 400.0, 10, 4, 8.0, lifespan, isInitialized)
class Deer(lifespan: Int, isInitialized: Boolean) : Herbivore("🦌", "Олень", 300.0, 12, 4, 6.0, lifespan, isInitialized)
class Rabbit(lifespan: Int, isInitialized: Boolean) : Herbivore("🐇", "Кролик", 2.0, 30, 2, 0.3, lifespan, isInitialized)
class Mouse(lifespan: Int, isInitialized: Boolean) : Herbivore("🐁", "Мышь", 0.05, 50, 1, 0.02, lifespan, isInitialized)
class Goat(lifespan: Int, isInitialized: Boolean) : Herbivore("🐐", "Коза", 60.0, 15, 3, 1.5, lifespan, isInitialized)
class Sheep(lifespan: Int, isInitialized: Boolean) : Herbivore("🐑", "Овца", 70.0, 15, 3, 2.0, lifespan, isInitialized)
class Boar(lifespan: Int, isInitialized: Boolean) : Herbivore("🐗", "Кабан", 400.0, 8, 2, 6.0, lifespan, isInitialized)
class Buffalo(lifespan: Int, isInitialized: Boolean) : Herbivore("🐃", "Буйвол", 700.0, 5, 3, 12.0, lifespan, isInitialized)
class Duck(lifespan: Int, isInitialized: Boolean) : Herbivore("🦆", "Утка", 1.0, 20, 4, 0.2, lifespan, isInitialized)
class Caterpillar(lifespan: Int, isInitialized: Boolean) : Herbivore("🐛", "Гусеница", 0.01, 100, 0, 0.0, lifespan, isInitialized)
