package com.example.moviesapplication.Util

import java.text.SimpleDateFormat
import java.util.*

class ConvertDateTime {

    fun convertDate(date: String): String {
        try {
            var spf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            spf.timeZone = TimeZone.getTimeZone("UTC")
            val newDate = spf.parse(date.toString())
            spf = SimpleDateFormat("dd MMM yyyy - HH:mm")
            spf.timeZone = TimeZone.getDefault()
            return spf.format(newDate)
        } catch (e: java.lang.Exception) {
            return date
        }
    }

}