import java.io.File
import java.io.PrintWriter

// Функция для шифрования текста
fun encrypt(text: String, shift: Int): String {
    return text.map { char ->
        when {
            char.isUpperCase() -> (char.code - 'A'.code + shift) % 26 + 'A'.code
            char.isLowerCase() -> (char.code - 'a'.code + shift) % 26 + 'a'.code
            else -> char.code
        }.toChar()
    }.joinToString("")
}

// Функция для расшифровки текста
fun decrypt(text: String, shift: Int): String {
    return encrypt(text, 26 - shift)
}

// Функция для чтения текста из файла
fun readFile(filePath: String): String {
    val file = File(filePath)
    if (!file.exists()) {
        throw IllegalArgumentException("Файл не существует: $filePath")
    }
    return file.readText()
}

// Функция для записи текста в файл
fun writeFile(filePath: String, text: String) {
    PrintWriter(filePath).use { it.write(text) }
}

// Функция для шифрования текста из файла
fun encryptFile(inputFilePath: String, outputFilePath: String, shift: Int) {
    val text = readFile(inputFilePath)
    val encryptedText = encrypt(text, shift)
    writeFile(outputFilePath, encryptedText)
}

// Функция для расшифровки текста из файла
fun decryptFile(inputFilePath: String, outputFilePath: String, shift: Int) {
    val text = readFile(inputFilePath)
    val decryptedText = decrypt(text, shift)
    writeFile(outputFilePath, decryptedText)
}

// Функция для расшифровки методом brute force
fun bruteForceDecryptFile(inputFilePath: String, outputFilePath: String) {
    val text = readFile(inputFilePath)
    for (shift in 1..25) {
        val decryptedText = decrypt(text, shift)
        writeFile("$outputFilePath-$shift", decryptedText)
    }
}

// Функция для расшифровки методом статистического анализа
fun statisticalAnalysisDecryptFile(inputFilePath: String, outputFilePath: String) {
    val text = readFile(inputFilePath)
    val letterFrequencies = mapOf(
        'E' to 12.70, 'T' to 9.06, 'A' to 8.17, 'O' to 7.51, 'I' to 6.97,
        'N' to 6.75, 'S' to 6.33, 'H' to 6.09, 'R' to 5.99, 'D' to 4.25,
        'L' to 4.03, 'C' to 2.78, 'U' to 2.76, 'M' to 2.41, 'W' to 2.36,
        'F' to 2.23, 'G' to 2.02, 'Y' to 1.97, 'P' to 1.93, 'B' to 1.49,
        'V' to 0.98, 'K' to 0.77, 'J' to 0.15, 'X' to 0.15, 'Q' to 0.10, 'Z' to 0.07
    )

    val letterCount = mutableMapOf<Char, Int>()
    text.filter { it.isLetter() }.forEach { char ->
        val upperChar = char.uppercaseChar()
        letterCount[upperChar] = letterCount.getOrDefault(upperChar, 0) + 1
    }

    val totalLetters = letterCount.values.sum()
    val letterFrequenciesInText = letterCount.mapValues { (_, count) -> count.toDouble() / totalLetters * 100 }

    val mostFrequentLetter = letterFrequenciesInText.maxByOrNull { it.value }?.key ?: 'E'
    val expectedMostFrequentLetter = letterFrequencies.maxByOrNull { it.value }?.key ?: 'E'

    val shift = (mostFrequentLetter.code - expectedMostFrequentLetter.code) % 26
    val decryptedText = decrypt(text, shift)
    writeFile(outputFilePath, decryptedText)

}

fun main() {
    val menu = """
        Выберите режим работы:
        1. Шифрование текста
        2. Расшифровка текста с известным ключом
        3. Расшифровка текста методом brute force
        4. Расшифровка текста методом статистического анализа
        5. Выход
    """.trimIndent()

    while (true) {
        println(menu)
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                println("Введите путь к файлу для шифрования:")
                val inputFilePath = readlnOrNull() ?: continue
                println("Введите путь для сохранения зашифрованного файла:")
                val outputFilePath = readlnOrNull() ?: continue
                println("Введите сдвиг (ключ):")
                val shift = readlnOrNull()?.toIntOrNull() ?: continue
                encryptFile(inputFilePath, outputFilePath, shift)
                println("Текст зашифрован и сохранен в $outputFilePath")
            }
            2 -> {
                println("Введите путь к файлу для расшифровки:")
                val inputFilePath = readlnOrNull() ?: continue
                println("Введите путь для сохранения расшифрованного файла:")
                val outputFilePath = readlnOrNull() ?: continue
                println("Введите сдвиг (ключ):")
                val shift = readlnOrNull()?.toIntOrNull() ?: continue
                decryptFile(inputFilePath, outputFilePath, shift)
                println("Текст расшифрован и сохранен в $outputFilePath")
            }
            3 -> {
                println("Введите путь к файлу для расшифровки методом brute force:")
                val inputFilePath = readlnOrNull() ?: continue
                println("Введите путь для сохранения расшифрованных файлов:")
                val outputFilePath = readlnOrNull() ?: continue
                bruteForceDecryptFile(inputFilePath, outputFilePath)
                println("Текст расшифрован методом brute force и сохранен в $outputFilePath-X")
            }
            4 -> {
                println("Введите путь к файлу для расшифровки методом статистического анализа:")
                val inputFilePath = readlnOrNull() ?: continue
                println("Введите путь для сохранения расшифрованного файла:")
                val outputFilePath = readlnOrNull() ?: continue
                statisticalAnalysisDecryptFile(inputFilePath, outputFilePath)
                println("Текст расшифрован методом статистического анализа и сохранен в $outputFilePath")
            }
            5 -> {
                println("Выход из программы.")
                break
            }
            else -> {
                println("Неверный выбор. Пожалуйста, выберите режим работы из меню.")
            }
        }
    }
}
