package com.example.project0.utils

import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun parseDate(date: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z")
    return try {
        val zonedDateTime = ZonedDateTime.parse(date, formatter)
        zonedDateTime.toLocalDate()
    } catch (e: Exception) {
        LocalDate.now()
    }
}

fun formatDate(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
    return date.format(formatter)
}