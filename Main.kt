import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.math.PI

fun convertToBinary(number: Int): String {
    if (number < 0) {
        throw IllegalArgumentException("Ошибка: число не может быть отрицательным")
    }
    return Integer.toBinaryString(number)
}
fun checkDivisibility(dividend: Int, divisor: Int) {
    if (divisor == 0) {
        throw ArithmeticException("Ошибка: деление на ноль недопустимо")
    }
    if (dividend % divisor == 0) {
        println("$dividend делится на $divisor без остатка")
    } else {
        println("$dividend не делится на $divisor без остатка")
    }
}
fun getElementByIndex(list: List<Int>, index: Int): Int {
    if (index < 0 || index >= list.size) {
        throw IndexOutOfBoundsException("Ошибка: индекс выходит за пределы списка")
    }
    return list[index]
}
class WeakPasswordException(message: String) : Exception(message)

fun checkPassword(password: String) {
    if (password.length < 8) {
        throw WeakPasswordException("Ошибка: пароль слишком короткий")
    }
    println("Пароль надежный")
}
fun checkDate(dateString: String) {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    try {
        LocalDate.parse(dateString, formatter)
        println("Дата корректна")
    } catch (e: DateTimeParseException) {
        throw DateTimeParseException("Ошибка: неверный формат даты", dateString, 0)
    }
}
fun concatenateStrings(str1: String?, str2: String?): String {
    if (str1 == null || str2 == null) {
        throw NullPointerException("Ошибка: одна из строк равна null")
    }
    return str1 + str2
}
fun remainder(dividend: Int, divisor: Int): Int {
    if (divisor == 0) {
        throw ArithmeticException("Ошибка: деление на ноль недопустимо")
    }
    return dividend % divisor
}
fun squareRoot(number: Double): Double {
    if (number < 0) {
        throw IllegalArgumentException("Ошибка: невозможно найти корень из отрицательного числа")
    }
    return Math.sqrt(number)
}
fun celsiusToFahrenheit(celsius: Double): Double {
    val absoluteZeroCelsius = -273.15
    if (celsius < absoluteZeroCelsius) {
        throw IllegalArgumentException("Ошибка: температура ниже абсолютного нуля")
    }
    return (celsius * 9 / 5) + 32
}
fun checkString(str: String?) {
    if (str.isNullOrEmpty()) {
        throw IllegalArgumentException("Ошибка: строка пустая или равна null")
    }
    println("Строка корректна")
}

open class Person(var name: String, var age: Int, var gender: String) {

    open fun displayInfo() {
        println("name: $name, \tage: $age, \tgender: $gender")
    }

    fun increaseAge(years: Int = 1) {
        age += years
    }

    fun changeName(newName: String) {
        name = newName
    }

    fun changeGender(newGender: String) {
        gender = newGender
    }
}
open class Worker(name: String, age: Int, gender: String, var salary: Double) : Person(name, age, gender) {

    override fun displayInfo() {
        super.displayInfo()
        println("salary: $salary")
    }
}

class Manager(name: String, age: Int, gender: String, salary: Double) : Worker(name, age, gender, salary) {
    private val subordinates: MutableList<Worker> = mutableListOf()

    fun addSubordinate(worker: Worker) {
        subordinates.add(worker)
    }

    override fun displayInfo() {
        super.displayInfo()
        println("Subordinates:")
        for (subordinate in subordinates) {
            subordinate.displayInfo()
        }
    }
}

interface Animal {
    fun makeSound()
}

class Dog : Animal {
    override fun makeSound() {
        println("sound dog")
    }
}

class Cat : Animal {
    override fun makeSound() {
        println("sound cat")
    }
}

class Cow : Animal {
    override fun makeSound() {
        println("sound cow")
    }
}

abstract class Transport {
    abstract fun move()
}

class Car : Transport() {
    override fun move() {
        println("car is driving.")
    }
}

class Bike : Transport() {
    override fun move() {
        println("bike is riding.")
    }
}
data class Book(val title: String, val author: String, val year: Int)

class Library {
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun findBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author == author }
    }

    fun findBooksByYear(year: Int): List<Book> {
        return books.filter { it.year == year }
    }

    fun displayAllBooks() {
        for (book in books) {
            println("title: ${book.title}, author: ${book.author}, year: ${book.year}")
        }
    }
}
class BankAccount(private val accountNumber: String, private var balance: Double) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("deposited $amount. new balance: $balance")
        } else {
            println("deposit amount must be positive.")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("withdrew $amount. new balance: $balance")
        } else {
            println("insufficient funds or invalid amount.")
        }
    }

    fun getBalance(): Double {
        return balance
    }

    fun getAccountNumber(): String {
        return accountNumber
    }
}
class Counter {
    companion object {
        private var count = 0

        fun getCount(): Int {
            return count
        }
    }

    init {
        count++
    }
}
abstract class Shape {
    abstract fun getArea(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun getArea(): Double {
        return PI * radius * radius
    }
}

class Rectangle(private val width: Double, private val height: Double) : Shape() {
    override fun getArea(): Double {
        return width * height
    }
}
open class Animalle {
    open fun move() {
        println("The animal is moving.")
    }
}

class Fish : Animalle() {
    override fun move() {
        println("The fish is swimming.")
    }
}

class Bird : Animalle() {
    override fun move() {
        println("The bird is flying.")
    }
}

class Dog1 : Animalle() {
    override fun move() {
        println("The dog is running.")
    }
}
data class Student(val name: String, val group: String, val grade: Double)

class University {
    private val students: MutableList<Student> = mutableListOf()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun sortStudentsByName(): List<Student> {
        return students.sortedBy { it.name }
    }

    fun filterStudentsByGrade(minGrade: Double): List<Student> {
        return students.filter { it.grade >= minGrade }
    }

    fun displayAllStudents() {
        for (student in students) {
            println("Name: ${student.name}, Group: ${student.group}, Grade: ${student.grade}")
        }
    }
}
data class Product(val name: String, val price: Double, var quantity: Int)

class Store {
    private val products: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product) {
        products.add(product)
        println("Added product: ${product.name}")
    }

    fun removeProduct(name: String): Boolean {
        val product = products.find { it.name == name }
        return if (product != null) {
            products.remove(product)
            println("Removed product: $name")
            true
        } else {
            println("Product not found: $name")
            false
        }
    }

    fun findProductByName(name: String): Product? {
        return products.find { it.name == name }
    }

    fun displayAllProducts() {
        for (product in products) {
            println("Name: ${product.name}, Price: ${product.price}, Quantity: ${product.quantity}")
        }
    }
}
interface PaymentSystem {
    fun pay(amount: Double)
    fun refund(amount: Double)
}
class CreditCard(private val cardNumber: String) : PaymentSystem {
    override fun pay(amount: Double) {
        println("Paying $amount using Credit Card $cardNumber")
    }

    override fun refund(amount: Double) {
        println("Refunding $amount to Credit Card $cardNumber")
    }
}
class PayPal(private val email: String) : PaymentSystem {
    override fun pay(amount: Double) {
        println("Paying $amount using PayPal account $email")
    }

    override fun refund(amount: Double) {
        println("Refunding $amount to PayPal account $email")
    }
}
class UniqueID {
    companion object {
        private var nextId: Int = 1

        // Метод для получения следующего уникального идентификатора
        fun getNextId(): Int {
            return nextId++
        }
    }
}

// Пример класса, использующего UniqueID для генерации уникальных идентификаторов
class ExampleClass {
    val id: Int

    init {
        id = UniqueID.getNextId()
    }

    fun displayInfo() {
        println("ExampleClass instance with ID: $id")
    }
}
data class Point(val x: Double, val y: Double)

class Rectanglle(private val topLeft: Point, private val bottomRight: Point) {

    fun getArea(): Double {
        val width = bottomRight.x - topLeft.x
        val height = topLeft.y - bottomRight.y
        return width * height
    }

    fun displayInfo() {
        println("Top-left corner: (${topLeft.x}, ${topLeft.y})")
        println("Bottom-right corner: (${bottomRight.x}, ${bottomRight.y})")
        println("Area: ${getArea()}")
    }
}
data class ComplexNumber(val real: Double, val imaginary: Double) {

    fun add(other: ComplexNumber): ComplexNumber {
        val newReal = this.real + other.real
        val newImaginary = this.imaginary + other.imaginary
        return ComplexNumber(newReal, newImaginary)
    }

    fun subtract(other: ComplexNumber): ComplexNumber {
        val newReal = this.real - other.real
        val newImaginary = this.imaginary - other.imaginary
        return ComplexNumber(newReal, newImaginary)
    }

    fun multiply(other: ComplexNumber): ComplexNumber {
        val newReal = this.real * other.real - this.imaginary * other.imaginary
        val newImaginary = this.real * other.imaginary + this.imaginary * other.real
        return ComplexNumber(newReal, newImaginary)
    }

    fun divide(other: ComplexNumber): ComplexNumber {
        val denominator = other.real * other.real + other.imaginary * other.imaginary
        val newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator
        val newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator
        return ComplexNumber(newReal, newImaginary)
    }

    fun display() {
        println("$real + ${imaginary}i")
    }
}
data class Matrix(private val data: Array<Array<Double>>) {

    operator fun plus(other: Matrix): Matrix {
        require(data.size == other.data.size && data[0].size == other.data[0].size) {
            "Matrices must have the same dimensions for addition."
        }
        val result = Array(data.size) { Array(data[0].size) { 0.0 } }
        for (i in data.indices) {
            for (j in data[i].indices) {
                result[i][j] = data[i][j] + other.data[i][j]
            }
        }
        return Matrix(result)
    }

    operator fun times(other: Matrix): Matrix {
        require(data[0].size == other.data.size) {
            "Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication."
        }
        val result = Array(data.size) { Array(other.data[0].size) { 0.0 } }
        for (i in data.indices) {
            for (j in other.data[0].indices) {
                for (k in data[0].indices) {
                    result[i][j] += data[i][k] * other.data[k][j]
                }
            }
        }
        return Matrix(result)
    }

    fun display() {
        for (row in data) {
            println(row.joinToString(" "))
        }
    }
}
data class Weapon(val name: String, val damage: Int)

open class Character(val name: String, var health: Int, var weapon: Weapon) {

    open fun attack(target: Character) {
        println("$name attacks ${target.name} with ${weapon.name}!")
        target.takeDamage(weapon.damage)
    }

    fun takeDamage(damage: Int) {
        health -= damage
        println("$name takes $damage damage. Remaining health: $health")
        if (health <= 0) {
            println("$name has been defeated!")
        }
    }
    fun displayInfo() {
        println("$name - Health: $health, Weapon: ${weapon.name} (Damage: ${weapon.damage})")
    }
}

// Класс Player, наследующий от Character
class Playerr(name: String, health: Int, weapon: Weapon) : Character(name, health, weapon) {

    override fun attack(target: Character) {
        println("$name (Player) attacks ${target.name} with ${weapon.name}!")
        target.takeDamage(weapon.damage)
    }
}

// Класс Enemy, наследующий от Character
class Enemy(name: String, health: Int, weapon: Weapon) : Character(name, health, weapon) {

    // Метод для атаки (переопределенный)
    override fun attack(target: Character) {
        println("$name (Enemy) attacks ${target.name} with ${weapon.name}!")
        target.takeDamage(weapon.damage)
    }
}
data class Product1(val name: String, val price: Double)
data class Customer(val name: String) {
    private val orderHistory: MutableList<Order> = mutableListOf()
    fun addOrder(order: Order) {
        orderHistory.add(order)
    }
    fun displayOrderHistory() {
        println("Order history for customer ${name}:")
        for (order in orderHistory) {
            order.displayOrderDetails()
        }
    }
}
class Order(val customer: Customer) {
    private val products: MutableList<Product1> = mutableListOf()
    fun addProduct(product: Product1) {
        products.add(product)
    }
    fun getTotalCost(): Double {
        return products.sumOf { it.price }
    }
    fun displayOrderDetails() {
        println("Order for customer ${customer.name}:")
        for (product in products) {
            println("Product: ${product.name}, Price: ${product.price}")
        }
        println("Total cost: ${getTotalCost()}")
    }
}
open class Device(val brand: String) {
    fun turnOn() {
        println("$brand device is turned on.")
    }
    fun turnOff() {
        println("$brand device is turned off.")
    }
}
class Smartphone(brand: String) : Device(brand) {
    fun takePhoto() {
        println("Taking a photo with the $brand smartphone.")
    }
}
class Laptop(brand: String) : Device(brand) {
    fun code() {
        println("Coding on the $brand laptop.")
    }
}
data class Player(val name: String, val symbol: Char)

// Класс Game, управляющий логикой игры
class Game {
    private val board: Array<CharArray> = Array(3) { CharArray(3) { ' ' } }
    private var currentPlayer: Player
    private var players: List<Player>

    init {
        val player1 = Player("Player 1", 'X')
        val player2 = Player("Player 2", 'O')
        players = listOf(player1, player2)
        currentPlayer = player1
    }

    fun displayBoard() {
        println("Current board:")
        for (row in board) {
            for (cell in row ) {
                print("|$cell")
            }
            println("|")
        }
    }

    fun makeMove(row: Int, col: Int): Boolean {
        if (row !in 0 until 4 || col !in 0 until 4 || board[row][col] != ' ') {
            println("Invalid move. Try again.")
            return false
        }
        board[row][col] = currentPlayer.symbol
        return true
    }

    private fun checkWin(): Boolean {
        for (i in 0 until 3) {
            if ((board[i][0] == currentPlayer.symbol && board[i][1] == currentPlayer.symbol && board[i][2] == currentPlayer.symbol) ||
                (board[0][i] == currentPlayer.symbol && board[1][i] == currentPlayer.symbol && board[2][i] == currentPlayer.symbol)) {
                return true
            }
        }
        if ((board[0][0] == currentPlayer.symbol && board[1][1] == currentPlayer.symbol && board[2][2] == currentPlayer.symbol) ||
            (board[0][2] == currentPlayer.symbol && board[1][1] == currentPlayer.symbol && board[2][0] == currentPlayer.symbol)) {
            return true
        }
        return false
    }

    private fun checkDraw(): Boolean {
        for (row in board) {
            for (cell in row) {
                if (cell == ' ') {
                    return false
                }
            }
        }
        return true
    }

    private fun switchPlayer() {
        currentPlayer = if (currentPlayer == players[0]) players[1] else players[0]
    }

    fun startGame() {
        var gameOver = false
        while (!gameOver) {
            displayBoard()
            println("${currentPlayer.name}'s turn (${currentPlayer.symbol}):")

            var validInput = false
            var row = -1
            var col = -1

            while (!validInput) {
                print("Enter row (0, 1, 2): ")
                val rowInput = readLine()
                print("Enter column (0, 1, 2): ")
                val colInput = readLine()

                try {
                    row = rowInput?.toInt() ?: -1
                    col = colInput?.toInt() ?: -1
                    if (row in 0 until 3 && col in 0 until 3) {
                        validInput = true
                    } else {
                        println("Invalid input. Row and column must be between 0 and 2.")
                    }
                } catch (e: NumberFormatException) {
                    println("Invalid input. Please enter integers for row and column.")
                }
            }

            if (makeMove(row, col)) {
                if (checkWin()) {
                    displayBoard()
                    println("${currentPlayer.name} wins!")
                    gameOver = true
                } else if (checkDraw()) {
                    displayBoard()
                    println("It's a draw!")
                    gameOver = true
                } else {
                    switchPlayer()
                }
            }
        }
    }
}

fun main() {
    //11. Конвертация в двоичную систему.
    //Создайте функцию, которая конвертирует целое число в двоичную строку. Если число отрицательное, выбрасывайте исключение.
//    print("Введите целое число: ")
//    val number = readlnOrNull()?.toIntOrNull()
//    if (number == null) {
//        println("Ошибка: введенное значение не является целым числом")
//        return
//    }
//    try {
//        val binaryString = convertToBinary(number)
//        println("Двоичное представление числа: $binaryString")
//    } catch (e: IllegalArgumentException) {
//        println(e.message)
//    }

    //12. Проверка делимости.
    //Реализуйте функцию, которая принимает два числа и проверяет, делится ли первое число на второе. Если второе число равно нулю, выбрасывайте ArithmeticException.
//    print("Введите делимое: ")
//    val dividend = readlnOrNull()?.toIntOrNull()
//    if (dividend == null) {
//        println("Ошибка: введенное значение не является целым числом")
//        return
//    }
//    print("Введите делитель: ")
//    val divisor = readlnOrNull()?.toIntOrNull()
//    if (divisor == null) {
//        println("Ошибка: введенное значение не является целым числом")
//        return
//    }
//    try {
//        checkDivisibility(dividend, divisor)
//    } catch (e: ArithmeticException) {
//        println(e.message)
//    }

    //13. Чтение элемента списка.
    //Напишите функцию, которая возвращает элемент списка по индексу. Если индекс выходит за пределы списка, выбрасывайте IndexOutOfBoundsException.
//    print("Введите количество элементов в списке: ")
//    val size = readlnOrNull()?.toIntOrNull()
//    if (size == null || size < 0) {
//        println("Ошибка: введенное значение не является корректным количеством элементов")
//        return
//    }
//    val list = mutableListOf<Int>()
//    println("Введите элементы списка:")
//    for (i in 0 until size) {
//        print("Элемент ${i + 1}: ")
//        val element = readlnOrNull()?.toIntOrNull()
//        if (element == null) {
//            println("Ошибка: введенное значение не является целым числом")
//            return
//        }
//        list.add(element)
//    }
//    print("Введите индекс: ")
//    val index = readlnOrNull()?.toIntOrNull()
//    if (index == null) {
//        println("Ошибка: введенное значение не является целым числом")
//        return
//    }
//    try {
//        val element = getElementByIndex(list, index)
//        println("Элемент по индексу $index: $element")
//    } catch (e: IndexOutOfBoundsException) {
//        println(e.message)
//    }

    //14. Парольная проверка.
    //Создайте функцию для проверки сложности пароля. Если пароль содержит менее 8 символов, выбрасывайте исключение WeakPasswordException.
//    print("Введите пароль: ")
//    val password = readlnOrNull()
//    if (password == null) {
//        println("Ошибка: введенное значение не является строкой")
//        return
//    }
//    try {
//        checkPassword(password)
//    } catch (e: WeakPasswordException) {
//        println(e.message)
//    }

    //15. Проверка даты.
    //Напишите функцию, которая проверяет, является ли строка корректной датой в формате "dd.MM.yyyy". Если формат неверен, выбрасывайте DateTimeParseException.
//    print("Введите дату (dd.MM.yyyy): ")
//    val dateString = readlnOrNull()
//    if (dateString == null) {
//        println("Ошибка: введенное значение не является строкой")
//        return
//    }
//    try {
//        checkDate(dateString)
//    } catch (e: DateTimeParseException) {
//        println(e.message)
//    }

    //16. Конкатенация строк.
    //Реализуйте функцию, которая объединяет две строки. Если одна из строк равна null, выбрасывайте NullPointerException.
//    print("Введите первую строку: ")
//    val str1 = readlnOrNull()
//
//    print("Введите вторую строку: ")
//    val str2 = readlnOrNull()
//
//    try {
//        val result = concatenateStrings(str1, str2)
//        println("Конкатенированная строка: $result")
//    } catch (e: NullPointerException) {
//        println(e.message)
//    }

    //17. Остаток от деления.
    //Создайте функцию, которая возвращает остаток от деления двух чисел. Если второе число равно нулю, выбрасывайте исключение.
//    print("Введите делимое: ")
//    val dividend = readlnOrNull()?.toIntOrNull()
//    if (dividend == null) {
//        println("Ошибка: введенное значение не является целым числом")
//        return
//    }
//
//    print("Введите делитель: ")
//    val divisor = readlnOrNull()?.toIntOrNull()
//    if (divisor == null) {
//        println("Ошибка: введенное значение не является целым числом")
//        return
//    }
//
//    try {
//        val result = remainder(dividend, divisor)
//        println("Остаток от деления: $result")
//    } catch (e: ArithmeticException) {
//        println(e.message)
//    }

    //18. Квадратный корень.
    //Реализуйте функцию, которая находит квадратный корень числа. Если число отрицательное, выбрасывайте исключение.
//    print("Введите число: ")
//    val number = readlnOrNull()?.toDoubleOrNull()
//    if (number == null) {
//        println("Ошибка: введенное значение не является числом")
//        return
//    }
//    try {
//        val result = squareRoot(number)
//        println("Квадратный корень числа: $result")
//    } catch (e: IllegalArgumentException) {
//        println(e.message)
//    }

    //19. Конвертер температуры.
    //Напишите функцию, которая переводит температуру из Цельсия в Фаренгейт. Если температура меньше абсолютного нуля, выбрасывайте исключение.
//    print("Введите температуру в Цельсиях: ")
//    val celsius = readlnOrNull()?.toDoubleOrNull()
//    if (celsius == null) {
//        println("Ошибка: введенное значение не является числом")
//        return
//    }
//    try {
//        val fahrenheit = celsiusToFahrenheit(celsius)
//        println("Температура в Фаренгейтах: $fahrenheit")
//    } catch (e: IllegalArgumentException) {
//        println(e.message)
//    }

    //20. Проверка строки на пустоту.
    //Создайте функцию, которая проверяет, является ли строка пустой или null. Если строка пустая или равна null, выбрасывайте исключение.
//   print("Введите строку: ")
//    val str = readlnOrNull()
//    try {
//        checkString(str)
//    } catch (e: IllegalArgumentException) {
//        println(e.message)
//    }


    //1. Класс "Человек".
    //Создайте класс Person с полями name, age, gender. Реализуйте методы для вывода информации о человеке и увеличения его возраста. Добавьте метод для изменения имени.
    // Создаем объект класса Person
//    val person = Person("name", 20, "f")
//    person.displayInfo()
//    person.increaseAge(5)
//    person.displayInfo()
//    person.changeName("name2")
//    person.changeGender("m")
//    person.displayInfo()

    //2. Наследование: Класс "Работник" и "Менеджер".
    //Создайте класс Worker, который наследуется от класса Person, и добавьте поле salary. Создайте класс Manager, который наследует от Worker и добавляет поле для подчиненных сотрудников.
//    val worker1 = Worker("name", 30, "f", 50000.0)
//    val worker2 = Worker("name2", 35, "m", 45000.0)
//    val manager = Manager("name3", 40, "m", 70000.0)
//    manager.addSubordinate(worker1)
//    manager.addSubordinate(worker2)
//    manager.displayInfo()

    //3. Полиморфизм: Животные.
    //Создайте интерфейс Animal с методом makeSound(). Реализуйте классы Dog, Cat, и Cow, которые реализуют этот интерфейс. Продемонстрируйте полиморфизм на примере массива животных.
//    val animals: Array<Animal> = arrayOf(Dog(), Cat(), Cow())
//    for (animal in animals) {
//        animal.makeSound()
//    }

    //4. Абстрактный класс "Транспорт".
    //Создайте абстрактный класс Transport с абстрактным методом move(). Реализуйте классы Car и Bike, которые наследуются от Transport и реализуют метод move().
//    val car = Car()
//    val bike = Bike()
//    car.move()
//    bike.move()

    //5. Класс "Книга" и "Библиотека".
    //Создайте класс Book с полями title, author, и year. Создайте класс Library, который содержит коллекцию книг и методы для добавления книг, поиска по автору и году публикации.
//    val library = Library()
//    library.addBook(Book("title1", "author1", 1950))
//    library.addBook(Book("title2", "author2", 1960))
//    library.addBook(Book("title3", "author3", 1960))
//    library.addBook(Book("title4", "author4", 1980))
//    println("all books in the library:")
//    library.displayAllBooks()
//    println("\nbooks by author3:")
//    val orwellBooks = library.findBooksByAuthor("author3")
//    for (book in orwellBooks) {
//        println("title: ${book.title}, year: ${book.year}")
//    }
//    println("\nbooks published in 1960:")
//    val books1960 = library.findBooksByYear(1960)
//    for (book in books1960) {
//        println("Title: ${book.title}, Author: ${book.author}")
//    }

    //6. Инкапсуляция: Банк.
    //Создайте класс BankAccount с полями accountNumber, balance, и методами для пополнения и снятия средств. Обеспечьте инкапсуляцию для безопасности данных счета.
//    val account = BankAccount("123456789", 1000.0)
//    account.deposit(500.0)
//    account.withdraw(200.0)
//    println("Current balance: ${account.getBalance()}")
//    println("Account number: ${account.getAccountNumber()}")

    //7. Счетчик объектов.
    //Создайте класс Counter, который хранит количество созданных объектов данного класса. Реализуйте статическое поле для учета количества объектов и метод для его увеличения при каждом создании объекта.
//    val counter1 = Counter()
//    val counter2 = Counter()
//    val counter3 = Counter()
//    val counter4 = Counter()
//    val counter5 = Counter()
//    val counter6 = Counter()
//    val counter7 = Counter()
//    val counter8 = Counter()
//    val counter9 = Counter()
//    println("Total number of Counter objects created: ${Counter.getCount()}")

    //8. Площадь фигур.
    //Создайте абстрактный класс Shape с абстрактным методом getArea(). Реализуйте классы Circle и Rectangle, которые наследуют от Shape и вычисляют площадь круга и прямоугольника соответственно.
//    val circle = Circle(5.0)
//    println("area of the circle: ${circle.getArea()}")
//    val rectangle = Rectangle(4.0, 6.0)
//    println("area of the rectangle: ${rectangle.getArea()}")

    //9. Наследование: Животные и их движения.
    //Создайте класс Animal с методом move(). Реализуйте классы Fish, Bird и Dog, которые наследуют Animal и переопределяют метод move() (рыба плавает, птица летает, собака бегает).
//    val fish = Fish()
//    val bird = Bird()
//    val dog = Dog1()
//    fish.move()
//    bird.move()
//    dog.move()

    //10. Работа с коллекциями: Университет.
    //Создайте класс Student с полями name, group, grade. Создайте класс University, который содержит список студентов и методы для добавления студентов, сортировки по имени и фильтрации по успеваемости.
//    val university = University()
//    university.addStudent(Student("name1", "Group A", 4.5))
//    university.addStudent(Student("name2", "Group B", 3.8))
//    university.addStudent(Student("name3", "Group A", 4.2))
//    university.addStudent(Student("name4", "Group C", 3.0))
//    println("All students:")
//    university.displayAllStudents()
//    println("\nStudents sorted by name:")
//    val sortedStudents = university.sortStudentsByName()
//    for (student in sortedStudents) {
//        println("Name: ${student.name}, Group: ${student.group}, Grade: ${student.grade}")
//    }
//    println("\nStudents with grade 4.0 or higher:")
//    val filteredStudents = university.filterStudentsByGrade(4.0)
//    for (student in filteredStudents) {
//        println("Name: ${student.name}, Group: ${student.group}, Grade: ${student.grade}")
//    }

    //11. Класс "Магазин".
    //Реализуйте класс Product с полями name, price, и quantity. Создайте класс Store, который содержит список продуктов и методы для добавления, удаления и поиска товаров по имени.
//    val store = Store()
//    store.addProduct(Product("apple", 0.5, 100))
//    store.addProduct(Product("banana", 0.3, 150))
//    store.addProduct(Product("orange", 0.7, 80))
//    println("All products in the store:")
//    store.displayAllProducts()
//    val product = store.findProductByName("Banana")
//    if (product != null) {
//        println("\nFound product: Name: ${product.name}, Price: ${product.price}, Quantity: ${product.quantity}")
//    } else {
//        println("\nProduct not found.")
//    }
//    store.removeProduct("Orange")
//    println("\nAll products in the store after removal:")
//    store.displayAllProducts()

    //12. Интерфейс "Платежная система".
    //Создайте интерфейс PaymentSystem с методами pay() и refund(). Реализуйте классы CreditCard и PayPal, которые реализуют этот интерфейс.
//    val creditCard = CreditCard("1234-5678-9012-3456")
//    val payPal = PayPal("user@example.com")
//    creditCard.pay(100.0)
//    creditCard.refund(50.0)
//    payPal.pay(200.0)
//    payPal.refund(30.0)

    //13. Генерация уникальных идентификаторов.
    //Создайте класс UniqueID, который генерирует уникальные идентификаторы для объектов каждого созданного класса. Реализуйте этот функционал через статическое поле и метод.
//    val obj1 = ExampleClass()
//    val obj2 = ExampleClass()
//    val obj3 = ExampleClass()
//    obj1.displayInfo()
//    obj2.displayInfo()
//    obj3.displayInfo()

    //14. Класс "Точка" и "Прямоугольник".
    //Создайте класс Point с координатами x и y. Реализуйте класс Rectangle, который содержит две точки (левая верхняя и правая нижняя). Реализуйте метод для вычисления площади прямоугольника.
//    val topLeft = Point(1.0, 4.0)
//    val bottomRight = Point(5.0, 1.0)
//    val rectangle = Rectanglle(topLeft, bottomRight)
//    rectangle.displayInfo()

    //15. Комплексные числа.
    //Создайте класс ComplexNumber с полями для действительной и мнимой частей. Реализуйте методы для сложения, вычитания, умножения и деления комплексных чисел.
//    val num1 = ComplexNumber(5.0, 6.0)
//    val num2 = ComplexNumber(2.0, 14.0)
//    val sum = num1.add(num2)
//    val difference = num1.subtract(num2)
//    val product = num1.multiply(num2)
//    val quotient = num1.divide(num2)
//    println("num1: ")
//    num1.display()
//    println("num2: ")
//    num2.display()
//    println("Sum: ")
//    sum.display()
//    println("Difference: ")
//    difference.display()
//    println("Product: ")
//    product.display()
//    println("Quotient: ")
//    quotient.display()

    //16. Перегрузка операторов: Матрица.
    //Создайте класс Matrix, представляющий двумерную матрицу. Реализуйте методы для сложения и умножения матриц. Продемонстрируйте перегрузку методов.
//    val matrix1 = Matrix(arrayOf(
//        arrayOf(1.0, 2.0, 3.0),
//        arrayOf(4.0, 5.0, 6.0),
//        arrayOf(7.0, 8.0, 9.0)
//    ))
//    val matrix2 = Matrix(arrayOf(
//        arrayOf(9.0, 8.0, 7.0),
//        arrayOf(6.0, 5.0, 4.0),
//        arrayOf(3.0, 2.0, 1.0)
//    ))
//    val sumMatrix = matrix1 + matrix2
//    println("Sum of matrices:")
//    sumMatrix.display()
//    val matrix3 = Matrix(arrayOf(
//        arrayOf(1.0, 2.0),
//        arrayOf(3.0, 4.0)
//    ))
//    val matrix4 = Matrix(arrayOf(
//        arrayOf(5.0, 6.0),
//        arrayOf(7.0, 8.0)
//    ))
//    val productMatrix = matrix3 * matrix4
//    println("Product of matrices:")
//    productMatrix.display()

    //17. Создание игры с использованием ООП.
    //Реализуйте классы для небольшой текстовой игры, такие как Player, Enemy, Weapon, с полями и методами, описывающими их поведение.
//    val sword = Weapon("Sword", 20)
//    val bow = Weapon("Bow", 15)
//    val player = Playerr("Hero", 100, sword)
//    val enemy = Enemy("Goblin", 80, bow)
//    player.displayInfo()
//    enemy.displayInfo()
//    player.attack(enemy)
//    enemy.attack(player)
//    player.attack(enemy)

    //18. Автоматизированная система заказов.
    //Создайте классы Order, Customer, и Product. Реализуйте систему, где можно добавлять заказы, отображать общую стоимость заказа и просматривать историю заказов.
//    val product1 = Product1("Laptop", 1000.0)
//    val product2 = Product1("Smartphone", 500.0)
//    val product3 = Product1("Headphones", 100.0)
//    val customer = Customer("John Doe")
//    val order = Order(customer)
//    order.addProduct(product1)
//    order.addProduct(product2)
//    order.displayOrderDetails()
//    customer.addOrder(order)
//    val anotherOrder = Order(customer)
//    anotherOrder.addProduct(product3)
//    anotherOrder.displayOrderDetails()
//    customer.addOrder(anotherOrder)
//    customer.displayOrderHistory()

    //19. Наследование: Электроника.
    //Создайте класс Device с полем brand и методами turnOn() и turnOff(). Реализуйте классы Smartphone и Laptop, которые наследуют от Device и добавляют уникальные методы, например, takePhoto() для смартфона.
//    val smartphone = Smartphone("Apple")
//    val laptop = Laptop("Dell")
//    smartphone.turnOn()
//    smartphone.takePhoto()
//    smartphone.turnOff()
//    laptop.turnOn()
//    laptop.code()
//    laptop.turnOff()

    //20. Игра "Крестики-нолики".
    //Разработайте классы для игры "Крестики-нолики". Создайте класс Game, который управляет логикой игры, и классы Player, описывающие поведение игроков.
//    val game = Game()
//    game.startGame()
}