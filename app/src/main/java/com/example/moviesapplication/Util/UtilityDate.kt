package com.example.moviesapplication.util

import java.text.SimpleDateFormat
import java.util.*

object UtilityDate {
    fun convertDate(date: String): String {
        return try {
            var spf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            spf.timeZone = TimeZone.getTimeZone("UTC")
            val newDate = spf.parse(date.toString())
            spf = SimpleDateFormat("dd MMM yyyy - HH:mm")
            spf.timeZone = TimeZone.getDefault()
            spf.format(newDate)
        } catch (e: java.lang.Exception) {
            date
        }
    }
}