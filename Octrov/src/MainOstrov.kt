import island.*

fun main() {
    val simulation = IslandSimulation()
    simulation.startSimulation()

    Thread.sleep(300000) //300000 мс = 5 минут
    simulation.stopSimulation()
}
