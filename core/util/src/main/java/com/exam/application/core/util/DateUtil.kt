package com.exam.application.core.util

import android.content.Context
import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun String.timeAgo(): String? {
    return try {
        var input1 = this
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
        input1 = if (input1.endsWith("Z")) {
            input1.substring(0, input1.length - 1) + "GMT-00:00"
        } else {
            val inset = 6
            val s0 = input1.substring(0, input1.length - inset)
            val s1 = input1.substring(input1.length - inset, input1.length)
            s0 + "GMT" + s1
        }

        val date: Long = df.parse(input1).time
        val now = System.currentTimeMillis()
        val ago = DateUtils.getRelativeTimeSpanString(date, now, DateUtils.MINUTE_IN_MILLIS)
        ago.toString()
    } catch (e: Exception) {
        null
    }
}