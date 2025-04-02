package island

import animal.*
import herbivore.*
import predator.*
import java.util.concurrent.*
import java.util.*
import kotlin.random.Random

class IslandSimulation(
    private val width: Int = 20,
    private val height: Int = 10,
    private val dayDurationSeconds: Int = 3
) {
    private val cells = Array(width) { Array(height) { Cell() } }
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private val scanner = Scanner(System.`in`)
    private var dayCounter = 1
    private var secondsInDay = 0
    private val newAnimalsCount = mutableMapOf<String, Int>()
    private var running = true

    fun startSimulation() {
        initializeIsland()
        printIslandState()

        executor.scheduleAtFixedRate({
            if (!running) return@scheduleAtFixedRate

            updateIsland()
            printIslandState()

            if (++secondsInDay >= dayDurationSeconds) {
                endDay()
            }
        }, 1, 1, TimeUnit.SECONDS)
    }

    fun stopSimulation() {
        running = false
        executor.shutdown()
    }

    private fun initializeIsland() {
        for (x in 0 until width) {
            for (y in 0 until height) {
                cells[x][y].plants = Random.nextInt(3, 8)
            }
        }


        val initialAnimals = listOf(
            Wolf(Random.nextInt(150, 300), true) to 40,
            Boa(Random.nextInt(150, 300), true) to 45,
            Fox(Random.nextInt(150, 300), true) to 60,
            Bear(Random.nextInt(150, 300), true) to 25,
            Eagle(Random.nextInt(150, 300), true) to 50,
            Horse(Random.nextInt(150, 300), true) to 150,
            Deer(Random.nextInt(150, 300), true) to 200,
            Rabbit(Random.nextInt(150, 300), true) to 400,
            Mouse(Random.nextInt(150, 300), true) to 500,
            Goat(Random.nextInt(150, 300), true) to 200,
            Sheep(Random.nextInt(150, 300), true) to 200,
            Boar(Random.nextInt(150, 300), true) to 150,
            Buffalo(Random.nextInt(150, 300), true) to 80,
            Duck(Random.nextInt(150, 300), true) to 250,
            Caterpillar(Random.nextInt(150, 300), true) to 600
        )

        initialAnimals.forEach { (animal, count) ->
            repeat(count) {
                val x = Random.nextInt(width)
                val y = Random.nextInt(height)
                cells[x][y].animals.add(animal)
            }
        }
    }

    private fun updateIsland() {
        if (Random.nextDouble() < 0.2) {
            val x = Random.nextInt(width)
            val y = Random.nextInt(height)
            cells[x][y].plants = (cells[x][y].plants + Random.nextInt(1, 3)).coerceAtMost(20)
        }

        for (x in 0 until width) {
            for (y in 0 until height) {
                val cell = cells[x][y]

                cell.animals.toList().forEach { animal ->
                    if (Random.nextBoolean()) {
                        animal.eat(cell)
                    }

                    animal.reproduce(cell)?.let { newAnimal ->
                        if (cell.animals.count { it.name == newAnimal.name } < newAnimal.maxPerCell) {
                            cell.animals.add(newAnimal)
                            if (!newAnimal.isInitialized) {
                                newAnimalsCount[newAnimal.name] = newAnimalsCount.getOrDefault(newAnimal.name, 0) + 1
                            }
                        }
                    }

                    if (animal.speed > 0 && Random.nextDouble() < 0.3) {
                        val newX = (x + Random.nextInt(-animal.speed, animal.speed + 1)).coerceIn(0, width - 1)
                        val newY = (y + Random.nextInt(-animal.speed, animal.speed + 1)).coerceIn(0, height - 1)
                        if (newX != x || newY != y) {
                            animal.move(cell, cells[newX][newY])
                        }
                    }


                }

                if (secondsInDay == dayDurationSeconds - 1) {
                    cell.animals.removeAll { it.shouldDie() }
                }
            }
        }
    }

    private fun endDay() {
        println("\n=== День $dayCounter завершен ===")
        println("Статистика:")

        val animalCounts = mutableMapOf<String, Int>()
        for (x in 0 until width) {
            for (y in 0 until height) {
                cells[x][y].animals.forEach { animal ->
                    animalCounts[animal.name] = animalCounts.getOrDefault(animal.name, 0) + 1
                }
            }
        }

        println("Количество животных в конце дня:")
        if (animalCounts.isNotEmpty()) {
            animalCounts.toList().sortedByDescending { it.second }.forEach { (name, count) ->
                println("$name: $count")
            }
        } else {
            println("Животных не осталось")
        }

        println("\nПоявилось новых животных:")
        if (newAnimalsCount.isNotEmpty()) {
            newAnimalsCount.forEach { (name, count) -> println("$name: $count") }
        } else {
            println("Новых животных не появилось")
        }

        val totalPlants = cells.sumOf { row -> row.sumOf { it.plants } }
        println("\nВсего растений: $totalPlants")
        println("========================")
        println("Нажмите Enter для продолжения...")
        scanner.nextLine()

        for (x in 0 until width) {
            for (y in 0 until height) {
                cells[x][y].animals.forEach { it.energy = 100.0 }
            }
        }

        dayCounter++
        secondsInDay = 0
        newAnimalsCount.clear()
    }

    private fun printIslandState() {
        println("\n=== День $dayCounter, Секунда $secondsInDay ===")

        val animalCounts = mutableMapOf<String, Int>()
        for (x in 0 until width) {
            for (y in 0 until height) {
                cells[x][y].animals.forEach { animal ->
                    animalCounts[animal.name] = animalCounts.getOrDefault(animal.name, 0) + 1
                }
            }
        }

        println("Количество животных:")
        animalCounts.toList().sortedByDescending { it.second }.forEach { (name, count) ->
            println("$name: $count")
        }

        val totalPlants = cells.sumOf { row -> row.sumOf { it.plants } }
        println("\nВсего растений: $totalPlants")
        println("========================")
    }
}