package predator

import animal.*
import animal.Cell
import kotlin.random.Random

open class Predator(
    symbol: String,
    name: String,
    weight: Double,
    maxPerCell: Int,
    speed: Int,
    foodRequired: Double,
    lifespan: Int,
    isInitialized: Boolean
) : Animal(symbol, name, weight, maxPerCell, speed, foodRequired, lifespan, isInitialized) {

    private val preyProbabilities = mapOf(
        "Кролик" to 30,
        "Мышь" to 25,
        "Лошадь" to 10,
        "Олень" to 20,
        "Кабан" to 10,
        "Буйвол" to 5,
        "Коза" to 20,
        "Овца" to 20,
        "Утка" to 30,
        "Гусеница" to 15
    )

    override fun eat(cell: Cell) {
        val preyList = cell.animals.filter { it !is Predator }
        if (preyList.isEmpty()) return

        for (prey in preyList.shuffled()) {
            val probability = preyProbabilities[prey.name] ?: 0
            if (Random.nextInt(100) < probability) {
                cell.animals.remove(prey)
                energy += prey.weight * 0.7
                energy = energy.coerceAtMost(150.0)
                println("$name съел ${prey.name}")
                return
            }
        }
    }

    override fun reproduce(cell: Cell): Animal? {
        if (cell.animals.count { it.name == name } >= maxPerCell) return null
        if (Random.nextDouble() > 0.05) return null

        val partners = cell.animals.filter { it.name == name && it != this && it.energy > 50 }
        if (partners.isNotEmpty() && energy > 70) {
            println("$name размножился")
            return when (this) {
                is Wolf -> Wolf(lifespan, false)
                is Boa -> Boa(lifespan, false)
                is Fox -> Fox(lifespan, false)
                is Bear -> Bear(lifespan, false)
                is Eagle -> Eagle(lifespan, false)
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


class Wolf(lifespan: Int, isInitialized: Boolean) : Predator("🐺", "Волк", 50.0, 5, 3, 3.0, lifespan, isInitialized)
class Boa(lifespan: Int, isInitialized: Boolean) : Predator("🐍", "Удав", 15.0, 8, 1, 2.0, lifespan, isInitialized)
class Fox(lifespan: Int, isInitialized: Boolean) : Predator("🦊", "Лиса", 8.0, 10, 2, 1.5, lifespan, isInitialized)
class Bear(lifespan: Int, isInitialized: Boolean) : Predator("🐻", "Медведь", 500.0, 2, 2, 10.0, lifespan, isInitialized)
class Eagle(lifespan: Int, isInitialized: Boolean) : Predator("🦅", "Орел", 6.0, 5, 3, 1.0, lifespan, isInitialized)
