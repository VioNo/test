object DatabaseConnection {
    init {
        println("Создано подключение к базе данных.")
    }

    fun connect() {
        println("Подключение к базе данных установлено.")
    }
}
object Logger {
    private val logs: MutableList<String> = mutableListOf()

    fun log(message: String) {
        logs.add(message)
    }

    fun printLogs() {
        logs.forEach { println(it) }
    }
}

enum class OrderStatus {
    NEW,
    IN_PROGRESS,
    DELIVERED,
    CANCELLED
}

class ShopOrder(val orderId: String) {
    private var status: OrderStatus = OrderStatus.NEW

    fun changeStatus(newStatus: OrderStatus) {
        when (status) {
            OrderStatus.NEW -> {
                if (newStatus == OrderStatus.IN_PROGRESS || newStatus == OrderStatus.CANCELLED) {
                    status = newStatus
                } else {
                    println("Невозможно изменить статус с NEW на $newStatus")
                }
            }
            OrderStatus.IN_PROGRESS -> {
                if (newStatus == OrderStatus.DELIVERED || newStatus == OrderStatus.CANCELLED) {
                    status = newStatus
                } else {
                    println("Невозможно изменить статус с IN_PROGRESS на $newStatus")
                }
            }
            OrderStatus.DELIVERED -> {
                println("Невозможно изменить статус с DELIVERED на $newStatus")
            }
            OrderStatus.CANCELLED -> {
                println("Невозможно изменить статус с CANCELLED на $newStatus")
            }
        }
    }

    fun displayStatus() {
        println("Текущий статус заказа $orderId: $status")
    }
}
enum class Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}

fun getSeasonNameInRussian(season: Season): String {
    return when (season) {
        Season.WINTER -> "Зима"
        Season.SPRING -> "Весна"
        Season.SUMMER -> "Лето"
        Season.AUTUMN -> "Осень"
    }
}
fun main() {
//    val connection1 = DatabaseConnection
//    val connection2 = DatabaseConnection
//
//    println(connection1 === connection2) // true
//
//    connection1.connect()
//    connection2.connect()

//    Logger.log("log 1")
//    Logger.log("log 2")
//    Logger.log("log 3")
//
//    Logger.printLogs()

//    val order = ShopOrder("12345")
//
//    order.displayStatus()
//    order.changeStatus(OrderStatus.IN_PROGRESS)
//    order.displayStatus()
//    order.changeStatus(OrderStatus.DELIVERED)
//    order.displayStatus()
//    order.changeStatus(OrderStatus.CANCELLED)
//    order.displayStatus()

//    val seasons = Season.values()
//    for (season in seasons) {
//        println("${season.name}: ${getSeasonNameInRussian(season)}")
//    }
}