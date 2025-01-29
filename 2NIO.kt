import java.io.*
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.channels.CompletionHandler
import java.nio.channels.FileChannel
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

//задание 1
fun copyAndTransformFile(inputFile: String, outputFile: String) {
    try {
        BufferedReader(FileReader(inputFile)).use { reader ->
            BufferedWriter(FileWriter(outputFile)).use { writer ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    writer.write(line?.uppercase())
                    writer.newLine()
                }
            }
        }
    } catch (e: IOException) {
        println("Ошибка при чтении или записи файла: ${e.message}")
    }
}

//задание 2
interface TextProcessor {
    fun process(text: String): String
}

class SimpleTextProcessor : TextProcessor {
    override fun process(text: String): String {
        return text
    }
}

class UpperCaseDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String {
        return processor.process(text).uppercase()
    }
}

class TrimDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String {
        return processor.process(text).trim()
    }
}

class ReplaceDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String {
        return processor.process(text).replace(" ", "_")
    }
}

//задание 3
fun copyFileUsingIO(inputFile: String, outputFile: String) {
    try {
        BufferedReader(FileReader(inputFile)).use { reader ->
            BufferedWriter(FileWriter(outputFile)).use { writer ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    writer.write(line)
                    writer.newLine()
                }
            }
        }
    } catch (e: IOException) {
        println("Ошибка при чтении или записи файла: ${e.message}")
    }
}

fun copyFileUsingNIOForComparison(inputFile: String, outputFile: String) {
    try {
        FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ).use { srcChannel ->
            FileChannel.open(Paths.get(outputFile), StandardOpenOption.WRITE, StandardOpenOption.CREATE).use { destChannel ->
                val buffer = ByteBuffer.allocate(1024)
                while (srcChannel.read(buffer) > 0) {
                    buffer.flip()
                    destChannel.write(buffer)
                    buffer.clear()
                }
            }
        }
    } catch (e: IOException) {
        println("Ошибка при чтении или записи файла: ${e.message}")
    }
}

//задание 4
fun copyLargeFileUsingNIO(source: String, dest: String) {
    try {
        FileChannel.open(Paths.get(source), StandardOpenOption.READ).use { srcChannel ->
            FileChannel.open(Paths.get(dest), StandardOpenOption.WRITE, StandardOpenOption.CREATE).use { destChannel ->
                srcChannel.transferTo(0, srcChannel.size(), destChannel)
            }
        }
    } catch (e: IOException) {
        println("Ошибка при копировании файла: ${e.message}")
    }
}

//задание 5
fun readFileAsync(filePath: String) {
    try {
        AsynchronousFileChannel.open(Paths.get(filePath), StandardOpenOption.READ).use { channel ->
            val buffer = ByteBuffer.allocate(1024)
            channel.read(buffer, 0, buffer, object : CompletionHandler<Int, ByteBuffer> {
                override fun completed(result: Int, attachment: ByteBuffer) {
                    if (result != -1) {
                        attachment.flip()
                        val data = ByteArray(attachment.remaining())
                        attachment.get(data)
                        println(String(data))
                        attachment.clear()
                        channel.read(attachment, 0, attachment, this)
                    } else {
                        channel.close()
                    }
                }

                override fun failed(exc: Throwable, attachment: ByteBuffer) {
                    println("Ошибка при чтении файла: ${exc.message}")
                }
            })
        }
    } catch (e: Exception) {
        println("Ошибка при открытии файла: ${e.message}")
    }
}

fun main() {
    //задание 1
    val inputFile = "input.txt"
    val outputFile = "output.txt"
    copyAndTransformFile(inputFile, outputFile)
    println("Файл успешно скопирован и преобразован.")

    //задание 2
    val processor = ReplaceDecorator(
        UpperCaseDecorator(
            TrimDecorator(SimpleTextProcessor())
        )
    )
    val result = processor.process(" Hello world ")
    println(result) // Вывод: HELLO_WORLD

    //задание 3
    val largeFile = "largefile.txt"
    val outputFileIO = "output_io.txt"
    val outputFileNIO = "output_nio.txt"

    //IO
    val startTimeIO = System.currentTimeMillis()
    copyFileUsingIO(largeFile, outputFileIO)
    val endTimeIO = System.currentTimeMillis()
    println("Время выполнения IO: ${endTimeIO - startTimeIO} ms")

    //NIO
    val startTimeNIO = System.currentTimeMillis()
    copyFileUsingNIOForComparison(largeFile, outputFileNIO)
    val endTimeNIO = System.currentTimeMillis()
    println("Время выполнения NIO: ${endTimeNIO - startTimeNIO} ms")

    //задание 4
    val sourceFile = "largefile.txt"
    val destFile = "copied_largefile.txt"
    copyLargeFileUsingNIO(sourceFile, destFile)
    println("Файл успешно скопирован.")

    //задание 5
    val asyncFilePath = "largefile.txt"
    readFileAsync(asyncFilePath)
    println("Асинхронное чтение файла начато.")
}
