package com.example.weathercomposeapp.view

import android.annotation.SuppressLint
import android.icu.text.MeasureFormat
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.*


@SuppressLint("ConstantLocale")
private val mf = MeasureFormat.getInstance(Locale.getDefault(), MeasureFormat.FormatWidth.SHORT)
fun getCity(): String {
    return "Milan,Italy" //TODO: To get the city using the device location
}

fun setCurrentTemperature(d: Double): String {
    val measure = Measure(d, MeasureUnit.CELSIUS)
    return mf.format(measure)
}

fun setCurrentRealFeel(d: Double): String {
    val measure = Measure(d, MeasureUnit.CELSIUS)
    return "Real Feel: " + mf.format(measure)
}

fun getWeekdayToday(): String {
    val date = Calendar.getInstance().time
    val str = SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.time)
    return "$str  "
}

fun setMaxAndMinTemperature(min: Double, max: Double): String {
    val measureMin = Measure(min, MeasureUnit.CELSIUS)
    val measureMax = Measure(max, MeasureUnit.CELSIUS)
    return mf.format(measureMax) + " Max" + "/ " + mf.format(measureMin) + " Min"
}

@RequiresApi(Build.VERSION_CODES.O)
fun getEachHour(e: Long): String {
    val instant = Instant.ofEpochSecond(e)
    var hour = instant.atZone(ZoneId.systemDefault()).hour
    return when {
        hour == 12 -> "12:00PM"
        hour == 0 -> "12:00AM"
        hour > 12 -> {
            hour -= 12
            "$hour:00PM"
        }
        else -> "$hour:00AM"
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getWeekday(i: Int): String {
    val calendar = Calendar.getInstance()
    val date = calendar.time
    val localDateTime =
        LocalDateTime.from(date.toInstant().atZone(ZoneId.of("UTC"))).plusDays(i.toLong())
    return localDateTime.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
}
