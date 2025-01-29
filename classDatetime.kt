package com.example.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit
import java.time.DayOfWeek
import java.time.YearMonth
import kotlin.system.measureTimeMillis
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.Period
import java.util.concurrent.ThreadLocalRandom
import java.time.Duration
import java.util.Locale

fun getDayOfWeekInRussian(date: LocalDate): String {
    val dayOfWeek = date.dayOfWeek
    return when (dayOfWeek) {
        java.time.DayOfWeek.MONDAY -> "пн"
        java.time.DayOfWeek.TUESDAY -> "вт"
        java.time.DayOfWeek.WEDNESDAY -> "ср"
        java.time.DayOfWeek.THURSDAY -> "чт"
        java.time.DayOfWeek.FRIDAY -> "пт"
        java.time.DayOfWeek.SATURDAY -> "сб"
        java.time.DayOfWeek.SUNDAY -> "вс"
    }
}

fun formatDateWithLocale(date: LocalDate, locale: Locale): String {
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale)
    return date.format(formatter)
}

fun calculateWorkingHours(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Long {
    var totalWorkingHours = 0L
    var currentDateTime = startDateTime

    while (currentDateTime.isBefore(endDateTime)) {
        val dayOfWeek = currentDateTime.dayOfWeek
        if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
            val nextDay = currentDateTime.toLocalDate().plusDays(1).atStartOfDay()
            val duration = Duration.between(currentDateTime, nextDay).toHours()
            totalWorkingHours += duration
        }
        currentDateTime = currentDateTime.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0)
    }

    return totalWorkingHours
}
fun calculateTimeUntilEvent(eventDateTime: LocalDateTime): String {
    val currentDateTime = LocalDateTime.now()
    val duration = Duration.between(currentDateTime, eventDateTime)

    val hours = duration.toHours()
    val minutes = duration.toMinutes() % 60
    val seconds = duration.seconds % 60

    return "Осталось: $hours часов, $minutes минут, $seconds секунд"
}
fun generateRandomDate(startDate: LocalDate, endDate: LocalDate): LocalDate {
    val startEpochDay = startDate.toEpochDay()
    val endEpochDay = endDate.toEpochDay()
    val randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1)
    return LocalDate.ofEpochDay(randomEpochDay)
}

fun printMonthCalendar(month: Int, year: Int) {
    val yearMonth = YearMonth.of(year, month)
    val firstDayOfMonth = yearMonth.atDay(1)
    val lastDayOfMonth = yearMonth.atEndOfMonth()

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    println("Календарь на ${yearMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy"))}:")

    var currentDay = firstDayOfMonth
    while (currentDay <= lastDayOfMonth) {
        val dayOfWeek = currentDay.dayOfWeek
        val dayDescription = when (dayOfWeek) {
            DayOfWeek.SATURDAY, DayOfWeek.SUNDAY -> "Выходной"
            else -> "Рабочий день"
        }
        println("${currentDay} - $dayDescription")
        currentDay = currentDay.plusDays(1)
    }
}

fun calculateAge(birthDate: LocalDate): Int {
    val currentDate = LocalDate.now()
    return Period.between(birthDate, currentDate).years
}
fun convertUtcToTimeZone(utcDateTime: String, targetTimeZone: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    try {
        val localDateTime = LocalDateTime.parse(utcDateTime, formatter)
        val utcZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"))
        val targetZonedDateTime = utcZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone))
        return targetZonedDateTime.format(formatter)
    } catch (e: DateTimeParseException) {
        throw IllegalArgumentException("Некорректный формат даты и времени. Пожалуйста, используйте формат yyyy-MM-dd'T'HH:mm:ss.")
    }
}
fun longRunningMethod() {
    for (i in 1..1_000_000) {
        // Симуляция работы
        Math.sqrt(i.toDouble())
    }
}

fun measureExecutionTime(method: () -> Unit): Long {
    val executionTime = measureTimeMillis {
        method()
    }
    return executionTime
}

fun compareDates(date1: LocalDate, date2: LocalDate): String {
    return when {
        date1.isAfter(date2) -> "первая дата больше второй"
        date1.isBefore(date2) -> "вторая дата больше первой"
        else -> "Даты равны"
    }
}

fun daysUntilNewYear(): Long {
    val currentDate = LocalDate.now()
    val newYearDate = LocalDate.of(currentDate.year + 1, 1, 1)
    return ChronoUnit.DAYS.between(currentDate, newYearDate)
}

fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

fun countWeekendsInMonth(month: Int, year: Int): Int {
    val yearMonth = YearMonth.of(year, month)
    val firstDayOfMonth = yearMonth.atDay(1)
    val lastDayOfMonth = yearMonth.atEndOfMonth()

    var weekendCount = 0
    var currentDay = firstDayOfMonth

    while (currentDay <= lastDayOfMonth) {
        if (currentDay.dayOfWeek == DayOfWeek.SATURDAY || currentDay.dayOfWeek == DayOfWeek.SUNDAY) {
            weekendCount++
        }
        currentDay = currentDay.plusDays(1)
    }

    return weekendCount
}