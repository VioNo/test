import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executors
import java.util.concurrent.CyclicBarrier
import java.util.concurrent.Semaphore
import java.util.concurrent.Future
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread






class Counter {
    private var value = 0
    private val lock = ReentrantLock()

    fun increment() {
        lock.withLock {
            value++
        }
    }

    fun getValue(): Int {
        lock.withLock {
            return value
        }
    }
}

class Account(val id: Int, private var balance: Int) {
    private val lock = ReentrantLock()

    fun deposit(amount: Int) {
        lock.withLock {
            balance += amount
        }
    }

    fun withdraw(amount: Int) {
        lock.withLock {
            balance -= amount
        }
    }

    fun getBalance(): Int = lock.withLock { balance }
}

fun transfer(from: Account, to: Account, amount: Int) {
    if (from.getBalance() >= amount) {
        from.withdraw(amount)
        to.deposit(amount)
    }
}

fun factorial(n: Int): Int {
    return if (n <= 1) 1 else n * factorial(n - 1)
}
class Philosopher(private val name: String, private val leftFork: ReentrantLock, private val rightFork: ReentrantLock) : Thread() {
    override fun run() {
        repeat(3) {
            think()
            eat()
        }
    }

    private fun think() {
        println("$name is thinking.")
        Thread.sleep(100)
    }

    private fun eat() {
        // Преобразуем последний символ имени в число
        val lastChar = name.last().toString().toInt()
        val firstLock = if (lastChar % 2 == 0) leftFork else rightFork
        val secondLock = if (lastChar % 2 == 0) rightFork else leftFork

        firstLock.lock()
        secondLock.lock()
        try {
            println("$name is eating.")
            Thread.sleep(100)
        } finally {
            secondLock.unlock()
            firstLock.unlock()
        }
    }
}
fun multiplyRow(matrix1: Array<IntArray>, matrix2: Array<IntArray>, result: IntArray, row: Int) {
    for (col in matrix2[0].indices) {
        var sum = 0
        for (k in matrix1[0].indices) {
            sum += matrix1[row][k] * matrix2[k][col]
        }
        result[col] = sum
    }
}





fun main() {

//    //1
//    val counter = Counter()
//    val threads = List(5) {
//        Thread {
//            for (i in 1..1000) {
//                counter.increment()
//            }
//        }
//    }
//    threads.forEach { it.start() }
//    threads.forEach { it.join() }
//    println("Final Counter Value: ${counter.getValue()}")

//    //2
//    val sharedList = CopyOnWriteArrayList<Int>()
//
//    val threads = List(10) {
//        Thread {
//            for (i in 1..100) {
//                sharedList.add(i)
//            }
//        }
//    }
//
//    threads.forEach { it.start() }
//    threads.forEach { it.join() }
//
//    println("List size: ${sharedList.size}")

//    //3
//    val executor = Executors.newFixedThreadPool(4)
//
//    for (i in 1..20) {
//        executor.submit {
//            println("Task $i executed by ${Thread.currentThread().name}")
//        }
//    }
//
//    executor.shutdown()

//    //4
//    val account1 = Account(1, 1000)
//    val account2 = Account(2, 500)
//
//    val threads = List(5) {
//        Thread {
//            transfer(account1, account2, 100)
//        }
//    }
//
//    threads.forEach { it.start() }
//    threads.forEach { it.join() }
//
//    println("Account 1 Balance: ${account1.getBalance()}")
//    println("Account 2 Balance: ${account2.getBalance()}")

//    //5
//    val barrier = CyclicBarrier(5)
//
//    val threads = List(5) {
//        Thread {
//            println("Thread ${Thread.currentThread().name} is working")
//            barrier.await()
//            println("Thread ${Thread.currentThread().name} has finished the phase")
//        }
//    }
//
//    threads.forEach { it.start() }
//    threads.forEach { it.join() }

    //6
//    val semaphore = Semaphore(2)
//
//    val threads = List(5) {
//        Thread {
//            semaphore.acquire()
//            try {
//                println("Thread ${Thread.currentThread().name} is accessing the resource")
//                Thread.sleep(1000)
//            } finally {
//                semaphore.release()
//            }
//        }
//    }
//
//    threads.forEach { it.start() }
//    threads.forEach { it.join() }

//    //7
//    val executor = Executors.newFixedThreadPool(10)
//    val futures = List(10) { i ->
//        executor.submit({ factorial(i + 1) }) as Future<Int>
//    }
//
//    futures.forEach { future ->
//        println("Result: ${future.get()}")
//    }
//
//    executor.shutdown()

//    //8
//    val queue = LinkedBlockingQueue<Int>()
//
//    val producer = Thread {
//        for (i in 1..10) {
//            queue.put(i)
//            println("Produced $i")
//        }
//    }
//
//    val consumer = Thread {
//        while (true) {
//            val item = queue.take()
//            println("Consumed $item")
//            if (item == 10) break
//        }
//    }
//
//    producer.start()
//    consumer.start()
//
//    producer.join()
//    consumer.join()

//    //9
//    val array = IntArray(1000) { (Math.random() * 1000).toInt() }
//    val partSize = array.size / 4
//
//    val threads = List(4) { i ->
//        Thread {
//            val start = i * partSize
//            val end = if (i == 3) array.size else start + partSize
//            array.sort(start, end)
//        }
//    }
//
//    threads.forEach { it.start() }
//    threads.forEach { it.join() }
//
//    array.sort() // Final merge sort
//    println("Array sorted: ${array.joinToString()}")

//    //10
//    val forks = Array(5) { ReentrantLock() }
//    val philosophers = List(5) { i -> Philosopher("Philosopher ${i + 1}", forks[i], forks[(i + 1) % 5]) }
//
//    philosophers.forEach { it.start() }
//    philosophers.forEach { it.join() }

//    //11
//    val matrix1 = arrayOf(
//        intArrayOf(1, 2, 3),
//        intArrayOf(4, 5, 6),
//        intArrayOf(7, 8, 9)
//    )
//
//    val matrix2 = arrayOf(
//        intArrayOf(9, 8, 7),
//        intArrayOf(6, 5, 4),
//        intArrayOf(3, 2, 1)
//    )
//
//    val result = IntArray(matrix2[0].size) { 0 }
//    val executor = Executors.newFixedThreadPool(3)
//
//    for (i in matrix1.indices) {
//        executor.submit {
//            multiplyRow(matrix1, matrix2, result, i)
//        }
//    }
//
//    executor.shutdown()
//    while (!executor.isTerminated) {
//        // Wait for all tasks to complete
//    }
//
//    println("Result matrix: ${result.joinToString(", ") { it.toString() }}")

    //12
    var running = true

    // Thread to start the timer
    val timerThread = thread(start = false) {
        var seconds = 0
        while (running) {
            println("Time: ${seconds}s")
            Thread.sleep(1000) // Sleep for 1 second
            seconds++
        }
    }

    // Thread to stop the timer after 10 seconds
    val stopperThread = thread {
        Thread.sleep(11000) // Sleep for 10 seconds
        running = false
        println("Timer stopped.")
    }

    // Start the timer thread
    timerThread.start()

    // Wait for the stopper thread to finish
    stopperThread.join()
    timerThread.join()
}
