package com.exam.application.core.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date
import java.util.Locale


fun Date.formatDayMonthYear(): String {
    return SimpleDateFormat("dd/MM/yyyy", Locale.US).format(this)
}

fun Date.formatDateTime(): String {
    return SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US).format(this)
}

fun Date.formatNotificationDateTime(): String {
    return SimpleDateFormat("dd/MM/yyyy • HH:mm น.", Locale.US).format(this)
}

fun Date.daysBetweenToday(): Int {
    return ChronoUnit.DAYS.between(LocalDate.now(), this.toLocalDate()).toInt()
}

fun Date.daysPlus(num: Long): String {
    val day = this.toLocalDate().plusDays(num)
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return day.format(formatter)
}

fun Date.toLocalDate(): LocalDate {
    return this.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
}

fun String.toDate(): Date? {
    return try {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        formatter.parse(this)
    } catch (e: Exception) {
        null
    }
}

fun generateNotificationIdByTime(): Int {
    return try {
        SimpleDateFormat("ddHHmmss", Locale.US).format(Date()).toInt()
    } catch (e: Exception) {
        1
    }
}

fun getCurrentDate(): String {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
    return dateFormat.format(calendar.time)
}