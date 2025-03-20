import java.util.concurrent.Executors
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.Random

// Abstract class Animal
abstract class Animal(
    val symbol: String,
    val name: String,
    val weight: Double,
    val maxPerCell: Int,
    val speed: Int,
    val foodRequired: Double,
    var lifespan: Int, // Lifespan in seconds
    val isInitialized: Boolean // Flag to mark initially created animals
) {
    var energy: Double = 100.0

    abstract fun eat(cell: Cell)
    abstract fun reproduce(cell: Cell): Animal?
    abstract fun move(cell: Cell, newCell: Cell, printMessages: Boolean)

    fun decreaseEnergy() {
        energy -= foodRequired
        if (energy <= 0) {
            lifespan = 0 // Mark for death
        }
    }
}

// Base class for predators
open class Predator(symbol: String, name: String, weight: Double, maxPerCell: Int, speed: Int, foodRequired: Double, lifespan: Int, isInitialized: Boolean) :
    Animal(symbol, name, weight, maxPerCell, speed, foodRequired, lifespan, isInitialized) {
    override fun eat(cell: Cell) {
        val preyProbabilities = mapOf(
            "Кролик" to 60,
            "Мышь" to 50,
            "Лошадь" to 40,
            "Олень" to 80,
            "Кабан" to 15,
            "Буйвол" to 10,
            "Коза" to 70,
            "Овца" to 70,
            "Утка" to 60,
            "Гусеница" to 40
        )

        val preyList = cell.animals.filter { it !is Predator }
        for (prey in preyList) {
            val probability = preyProbabilities[prey.name] ?: 0
            if (Random().nextInt(100) < probability) {
                cell.animals.remove(prey)
                energy += prey.weight * 0.5
                println("$name ate ${prey.name}")
                break
            }
        }
    }

    override fun reproduce(cell: Cell): Animal? {
        val partner = cell.animals.filter { it.name == name && it != this }.randomOrNull()
        return partner?.let {
            if (cell.animals.count { it.name == name } < maxPerCell) {
                println("$name reproduced")
                when (this) {
                    is Wolf -> Wolf(Random().nextInt(120, 600), false)
                    is Boa -> Boa(Random().nextInt(120, 600), false)
                    is Fox -> Fox(Random().nextInt(120, 600), false)
                    is Bear -> Bear(Random().nextInt(120, 600), false)
                    is Eagle -> Eagle(Random().nextInt(120, 600), false)
                    else -> null
                }
            } else null
        }
    }

    override fun move(cell: Cell, newCell: Cell, printMessages: Boolean) {
        if (newCell.animals.count { it.name == name } < maxPerCell) {
            cell.animals.remove(this)
            newCell.animals.add(this)
            if (printMessages && !isInitialized) {
                println("$name moved to new cell")
            }
        }
    }
}

// Base class for herbivores
open class Herbivore(symbol: String, name: String, weight: Double, maxPerCell: Int, speed: Int, foodRequired: Double, lifespan: Int, isInitialized: Boolean) :
    Animal(symbol, name, weight, maxPerCell, speed, foodRequired, lifespan, isInitialized) {
    override fun eat(cell: Cell) {
        if (cell.plants > 0) {
            cell.plants--
            energy += 10
            println("$name ate a plant")
        }
    }

    override fun reproduce(cell: Cell): Animal? {
        val partner = cell.animals.filter { it.name == name && it != this }.randomOrNull()
        return partner?.let {
            if (cell.animals.count { it.name == name } < maxPerCell) {
                println("$name reproduced")
                when (this) {
                    is Horse -> Horse(Random().nextInt(120, 600), false)
                    is Deer -> Deer(Random().nextInt(120, 600), false)
                    is Rabbit -> Rabbit(Random().nextInt(120, 600), false)
                    is Mouse -> Mouse(Random().nextInt(120, 600), false)
                    is Goat -> Goat(Random().nextInt(120, 600), false)
                    is Sheep -> Sheep(Random().nextInt(120, 600), false)
                    is Boar -> Boar(Random().nextInt(120, 600), false)
                    is Buffalo -> Buffalo(Random().nextInt(120, 600), false)
                    is Duck -> Duck(Random().nextInt(120, 600), false)
                    is Caterpillar -> Caterpillar(Random().nextInt(120, 600), false)
                    else -> null
                }
            } else null
        }
    }

    override fun move(cell: Cell, newCell: Cell, printMessages: Boolean) {
        if (newCell.animals.count { it.name == name } < maxPerCell) {
            cell.animals.remove(this)
            newCell.animals.add(this)
            if (printMessages && !isInitialized) {
                println("$name moved to new cell")
            }
        }
    }
}

// Specific animal classes with lifespan and initialization flag
class Wolf(lifespan: Int, isInitialized: Boolean) : Predator("🐺", "Волк", 50.0, 30, 3, 8.0, lifespan, isInitialized)
class Boa(lifespan: Int, isInitialized: Boolean) : Predator("🐍", "Удав", 15.0, 30, 1, 3.0, lifespan, isInitialized)
class Fox(lifespan: Int, isInitialized: Boolean) : Predator("🦊", "Лиса", 8.0, 30, 2, 2.0, lifespan, isInitialized)
class Bear(lifespan: Int, isInitialized: Boolean) : Predator("🐻", "Медведь", 500.0, 5, 2, 80.0, lifespan, isInitialized)
class Eagle(lifespan: Int, isInitialized: Boolean) : Predator("🦅", "Орел", 6.0, 20, 3, 1.0, lifespan, isInitialized)
class Horse(lifespan: Int, isInitialized: Boolean) : Herbivore("🐎", "Лошадь", 400.0, 20, 4, 60.0, lifespan, isInitialized)
class Deer(lifespan: Int, isInitialized: Boolean) : Herbivore("🦌", "Олень", 300.0, 20, 4, 50.0, lifespan, isInitialized)
class Rabbit(lifespan: Int, isInitialized: Boolean) : Herbivore("🐇", "Кролик", 2.0, 150, 2, 0.45, lifespan, isInitialized)
class Mouse(lifespan: Int, isInitialized: Boolean) : Herbivore("🐁", "Мышь", 0.05, 500, 1, 0.01, lifespan, isInitialized)
class Goat(lifespan: Int, isInitialized: Boolean) : Herbivore("🐐", "Коза", 60.0, 140, 3, 10.0, lifespan, isInitialized)
class Sheep(lifespan: Int, isInitialized: Boolean) : Herbivore("🐑", "Овца", 70.0, 140, 3, 15.0, lifespan, isInitialized)
class Boar(lifespan: Int, isInitialized: Boolean) : Herbivore("🐗", "Кабан", 400.0, 50, 2, 50.0, lifespan, isInitialized)
class Buffalo(lifespan: Int, isInitialized: Boolean) : Herbivore("🐃", "Буйвол", 700.0, 10, 3, 100.0, lifespan, isInitialized)
class Duck(lifespan: Int, isInitialized: Boolean) : Herbivore("🦆", "Утка", 1.0, 200, 4, 0.15, lifespan, isInitialized)
class Caterpillar(lifespan: Int, isInitialized: Boolean) : Herbivore("🐛", "Гусеница", 0.01, 1000, 0, 0.0, lifespan, isInitialized)

// Data class to hold animal type and count
data class AnimalCount(val animalType: Animal, var count: Int)

// Cell class to represent a location on the island
data class Cell(var plants: Int = 0, val animals: MutableList<Animal> = mutableListOf())

// IslandSimulation class to manage the simulation
class IslandSimulation(val width: Int, val height: Int) {
    private val scheduler = ScheduledThreadPoolExecutor(1)
    private val executor = Executors.newCachedThreadPool()
    private val cells = Array(width) { row -> Array(height) { Cell() } }
    private val random = Random()

    fun startSimulation() {
        initializeIsland()
        printInitialState()
        scheduler.scheduleAtFixedRate({
            executor.submit {
                updateIsland(printMessages = true)
                printIsland()
                printStatistics()
            }
        }, 0, 1, TimeUnit.SECONDS) // Start updating immediately
    }

    private fun initializeIsland() {
        val initialAnimals = listOf(
            AnimalCount(Wolf(Random().nextInt(120, 600), true), 20),
            AnimalCount(Boa(Random().nextInt(120, 600), true), 15),
            AnimalCount(Fox(Random().nextInt(120, 600), true), 25),
            AnimalCount(Bear(Random().nextInt(120, 600), true), 10),
            AnimalCount(Eagle(Random().nextInt(120, 600), true), 15),
            AnimalCount(Horse(Random().nextInt(120, 600), true), 30),
            AnimalCount(Deer(Random().nextInt(120, 600), true), 30),
            AnimalCount(Rabbit(Random().nextInt(120, 600), true), 100),
            AnimalCount(Mouse(Random().nextInt(120, 600), true), 150),
            AnimalCount(Goat(Random().nextInt(120, 600), true), 40),
            AnimalCount(Sheep(Random().nextInt(120, 600), true), 40),
            AnimalCount(Boar(Random().nextInt(120, 600), true), 30),
            AnimalCount(Buffalo(Random().nextInt(120, 600), true), 20),
            AnimalCount(Duck(Random().nextInt(120, 600), true), 50),
            AnimalCount(Caterpillar(Random().nextInt(120, 600), true), 200)
        )

        var animalIndex = 0
        for (x in 0 until width) {
            for (y in 0 until height) {
                val cell = cells[x][y]
                cell.plants = 5

                while (animalIndex < initialAnimals.size && cell.animals.size < 5) {
                    val animalCount = initialAnimals[animalIndex]
                    if (animalCount.count > 0) {
                        cell.animals.add(animalCount.animalType)
                        animalCount.count--
                    } else {
                        animalIndex++
                    }
                }
            }
        }
    }

    private fun updateIsland(printMessages: Boolean) {
        for (x in 0 until width) {
            for (y in 0 until height) {
                val cell = cells[x][y]
                cell.plants += random.nextInt(2)

                // Remove dead animals
                cell.animals.removeIf { it.lifespan-- <= 0 || it.energy <= 0 }

                cell.animals.forEach { animal ->
                    animal.eat(cell)
                    val newAnimal = animal.reproduce(cell)
                    newAnimal?.let { cell.animals.add(it) }
                    val newX = (x + random.nextInt(animal.speed * 2 + 1) - animal.speed).coerceIn(0, width - 1)
                    val newY = (y + random.nextInt(animal.speed * 2 + 1) - animal.speed).coerceIn(0, height - 1)
                    animal.move(cell, cells[newX][newY], printMessages)
                    animal.decreaseEnergy()
                }
            }
        }
    }

    private fun printInitialState() {
        println("Initial State of the Island:")
        printIsland()
        printStatistics()
    }

    private fun printIsland() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                val cell = cells[x][y]
                val animalSymbols = cell.animals.joinToString("") { it.symbol }
                print("${if (cell.plants > 0) "🌱" else " "}$animalSymbols ")
            }
            println()
        }
    }

    private fun printStatistics() {
        val totalAnimals = cells.sumOf { row -> row.sumOf { cell -> cell.animals.size } }
        val totalPlants = cells.sumOf { row -> row.sumOf { cell -> cell.plants } }
        println("Total animals: $totalAnimals, Total plants: $totalPlants")
    }
}

fun main() {
    val simulation = IslandSimulation(20, 10) // Smaller island for testing
    simulation.startSimulation()
}
