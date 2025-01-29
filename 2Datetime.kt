package com.example
import com.example.utils.compareDates
import com.example.utils.daysUntilNewYear
import com.example.utils.isLeapYear
import com.example.utils.countWeekendsInMonth
import com.example.utils.measureExecutionTime
import com.example.utils.longRunningMethod
import com.example.utils.convertUtcToTimeZone
import com.example.utils.calculateAge
import com.example.utils.printMonthCalendar
import com.example.utils.generateRandomDate
import com.example.utils.calculateTimeUntilEvent
import com.example.utils.calculateWorkingHours
import com.example.utils.formatDateWithLocale
import com.example.utils.getDayOfWeekInRussian

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit
import java.time.DayOfWeek
import java.time.YearMonth
import java.time.LocalDateTime
import java.util.Locale






fun main() {
    // 1. Основы LocalDate и LocalTime
    //Задача: Напишите программу, которая:
    //Создает объект LocalDate, представляющий текущую дату.
    //Создает объект LocalTime, представляющий текущее время.
    //Выводит их значения в формате dd-MM-yyyy HH:mm:ss

    //объект LocalDate, текущая дата
    val currentDate = LocalDate.now()
    //объект LocalTime, текущая время
    val currentTime = LocalTime.now()
    //форматтер для даты
    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    //форматтер для времени
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    //форматируем
//    val formattedDate = currentDate.format(dateFormatter)
//    val formattedTime = currentTime.format(timeFormatter)
//    println("$formattedDate $formattedTime")

    //2. Сравнение дат
    //Задача: Напишите метод, который принимает две даты (LocalDate) и определяет, какая из них больше, меньше или равна другой. Верните соответствующее сообщение.
//    println("первая дата в формате dd-MM-yyyy:")
//    val input1 = readLine()
//    println("вторая дата в формате dd-MM-yyyy:")
//    val input2 = readLine()
//
//    try {
//        val date1 = LocalDate.parse(input1, dateFormatter)
//        val date2 = LocalDate.parse(input2, dateFormatter)
//
//        val result = compareDates(date1, date2)
//        println(result)
//    } catch (e: DateTimeParseException) {
//        println("ошибка ввода даты, используйте формат dd-MM-yyyy или корректные значения даты.")
//    }


    //3. Сколько дней до Нового года?
    //Задача: Создайте метод, который определяет количество дней до Нового года от текущей даты.
//    val daysLeft = daysUntilNewYear()
//    println("До Нового года осталось $daysLeft дней.")

    //4. Проверка високосного года
    //Задача: Реализуйте метод, который принимает год и возвращает true, если он является високосным, и false в противном случае.
//    println("Введите год:")
//    val input = readLine()
//    try {
//        val year = input?.toInt()
//        if (year != null) {
//            val result = isLeapYear(year)
//            println("Год $year ${if (result) "является високосным" else "не является високосным"}.")
//        } else {
//            println("введите целое число.")
//        }
//    } catch (e: NumberFormatException) {
//        println("введите целое число.")
//    }
    //5. Подсчет выходных за месяц
    //Задача: Напишите метод, который принимает месяц и год и возвращает количество выходных (суббот и воскресений) в этом месяце.
//    println("Введите месяц (1-12):")
//    val month = readLine()?.toIntOrNull()
//    println("Введите год:")
//    val year = readLine()?.toIntOrNull()
//
//    if (month != null && year != null && month in 1..12) {
//        val weekends = countWeekendsInMonth(month, year)
//        println("Количество выходных в месяце: $weekends")
//    } else {
//        println("Некорректный ввод. Пожалуйста, введите месяц от 1 до 12 и корректный год.")
//    }
    //6. Расчет времени выполнения метода
    //Задача: Реализуйте метод, который измеряет время выполнения другого метода (например, цикла из 1 миллиона итераций).
//    val timeTaken = measureExecutionTime { longRunningMethod() }
//    println("Время выполнения метода: $timeTaken миллисекунд/ы")
    //7. Форматирование и парсинг даты
    //Задача: Напишите программу, которая принимает строку даты в формате dd-MM-yyyy, конвертирует ее в объект LocalDate, добавляет к ней 10 дней и выводит результат в формате yyyy/MM/dd.
//    println("Введите дату в формате dd-MM-yyyy:")
//    val inputDate = readLine()
//
//    if (inputDate != null) {
//        try {
//            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//            val localDate = LocalDate.parse(inputDate, formatter)
//            val newDate = localDate.plusDays(10)
//            val outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
//            val formattedDate = newDate.format(outputFormatter)
//            println("Новая дата: $formattedDate")
//        } catch (e: DateTimeParseException) {
//            println("введите дату в формате dd-MM-yyyy.")
//        }
//    } else {
//        println("ввод пуст")
//    }
    //8. Конвертация между часовыми поясами
    //Задача: Напишите метод, который принимает дату и время в часовом поясе UTC и конвертирует его в другой часовой пояс, например, Europe/Moscow.
//    println("дата и время в формате yyyy-MM-dd'T'HH:mm:ss (UTC):")
//    val utcDateTime = readLine() //2002-02-20T12:00:00
//    println("целевой часовой пояс (например, Europe/Moscow):")
//    val targetTimeZone = readLine() //Europe/Moscow
//
//    if (utcDateTime != null && targetTimeZone != null) {
//        try {
//            val convertedDateTime = convertUtcToTimeZone(utcDateTime, targetTimeZone)
//            println("дата и время в часовом поясе $targetTimeZone: $convertedDateTime")
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    } else {
//        println("ввод пуст")
//    }
    //9. Вычисление возраста по дате рождения
    //Задача: Напишите метод, который принимает дату рождения в формате LocalDate и возвращает текущий возраст в годах.
//    println("дата рождения в формате dd-MM-yyyy:")
//    val inputDate = readLine()
//
//    if (inputDate != null) {
//        try {
//            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//            val birthDate = LocalDate.parse(inputDate, formatter)
//            val age = calculateAge(birthDate)
//            println("возраст: $age лет")
//        } catch (e: DateTimeParseException) {
//            println("ведите дату в формате dd-MM-yyyy.")
//        }
//    } else {
//        println("ввод пуст.")
//    }
    //10. Создание календаря на месяц
    //Задача: Напишите метод, который принимает месяц и год и выводит все даты месяца с указанием, является ли каждая из них рабочим днем или выходным.
//    println("Введите месяц (1-12):")
//    val monthInput = readLine()?.toIntOrNull()
//    println("Введите год:")
//    val yearInput = readLine()?.toIntOrNull()
//
//    if (monthInput != null && yearInput != null && monthInput in 1..12) {
//        printMonthCalendar(monthInput, yearInput)
//    } else {
//        println("Некорректный ввод. Пожалуйста, введите месяц от 1 до 12 и корректный год.")
//    }
    //11. Генерация случайной даты в диапазоне
    //Задача: Реализуйте метод, который принимает две даты и генерирует случайную дату в этом диапазоне.
//    println("1 дата в формате dd-MM-yyyy:")
//    val startDateInput = readLine()
//    println("2 дата в формате dd-MM-yyyy:")
//    val endDateInput = readLine()
//
//    if (startDateInput != null && endDateInput != null) {
//        try {
//            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//            val startDate = LocalDate.parse(startDateInput, formatter)
//            val endDate = LocalDate.parse(endDateInput, formatter)
//
//            if (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
//                val randomDate = generateRandomDate(startDate, endDate)
//                println("дата в диапазоне от ${startDate} до ${endDate}: ${randomDate.format(formatter)}")
//            } else {
//                println("1 дата должна б12ыть раньше или равна конечной дате.")
//            }
//        } catch (e: DateTimeParseException) {
//            println("введите даты в формате dd-MM-yyyy.")
//        }
//    } else {
//        println("ввод пуст")
//    }
    //12. Расчет времени до заданной даты
    //Задача: Создайте метод, который принимает дату и время события и рассчитывает, сколько часов, минут и секунд осталось до него от текущего момента.
//    println("дата и время события в формате yyyy-MM-dd'T'HH:mm:ss:")
//    val eventDateTimeInput = readLine()
//
//    if (eventDateTimeInput != null) {
//        try {
//            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
//            val eventDateTime = LocalDateTime.parse(eventDateTimeInput, formatter)
//
//            if (eventDateTime.isAfter(LocalDateTime.now())) {
//                val timeUntilEvent = calculateTimeUntilEvent(eventDateTime)
//                println(timeUntilEvent)
//            } else {
//                println("уже прошло.")
//            }
//        } catch (e: DateTimeParseException) {
//            println("формат yyyy-MM-dd'T'HH:mm:ss.")
//        }
//    } else {
//        println("ввод пуст")
//    }
    //13. Вычисление количества рабочих часов
    //Задача: Напишите метод, который принимает два объекта LocalDateTime, представляющие начало и конец рабочего дня, и возвращает количество рабочих часов (без учета выходных).
//    println("начало рабочего дня в формате yyyy-MM-dd'T'HH:mm:ss:")
//    val startDateTimeInput = readLine()
//    println("конец рабочего дня в формате yyyy-MM-dd'T'HH:mm:ss:")
//    val endDateTimeInput = readLine()
//
//    if (startDateTimeInput != null && endDateTimeInput != null) {
//        try {
//            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
//            val startDateTime = LocalDateTime.parse(startDateTimeInput, formatter)
//            val endDateTime = LocalDateTime.parse(endDateTimeInput, formatter)
//
//            if (startDateTime.isBefore(endDateTime)) {
//                val workingHours = calculateWorkingHours(startDateTime, endDateTime)
//                println("кол-во раб. ч: $workingHours ч")
//            } else {
//                println("дата начала должна быть раньше даты конца.")
//            }
//        } catch (e: DateTimeParseException) {
//            println("формат yyyy-MM-dd'T'HH:mm:ss.")
//        }
//    } else {
//        println("ввод пуст")
//    }
    //14. Конвертация даты в строку с учетом локали
    //Задача: Создайте метод, который принимает объект LocalDate и выводит его в строковом формате с учетом локали, например, ru или en.
//    println("дата в формате yyyy-MM-dd:")
//    val dateInput = readLine()
//    println("ru или en:")
//    val localeInput = readLine()
//
//    if (dateInput != null && localeInput != null) {
//        try {
//            val date = LocalDate.parse(dateInput)
//            val locale = Locale(localeInput)
//            val formattedDate = formatDateWithLocale(date, locale)
//            println("дата: $formattedDate")
//        } catch (e: Exception) {
//            println("некорректный формат")
//        }
//    } else {
//        println("ввод пуст")
//    }
    //15. Определение дня недели по дате
    //Задача: Напишите метод, который принимает дату и возвращает название дня недели на русском языке.
//    println("дата в формате yyyy-MM-dd:")
//    val dateInput = readLine()
//
//    if (dateInput != null) {
//        try {
//            val date = LocalDate.parse(dateInput)
//            val dayOfWeek = getDayOfWeekInRussian(date)
//            println("день недели: $dayOfWeek")
//        } catch (e: DateTimeParseException) {
//            println("формат yyyy-MM-dd.")
//        }
//    } else {
//        println("ввод пуст")
//    }


}

