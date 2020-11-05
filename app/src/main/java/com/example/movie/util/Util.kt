package com.example.movie.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun Number.toDecimalFormat(format: String = "0.0"): String = DecimalFormat(format).format(this)

fun Date.toFormat(format: String = "yyyy-MM-dd HH:MM:ss"): String = SimpleDateFormat(format, Locale.getDefault()).format(this)

fun String.toDate(format: String = "yyyy-MM-dd HH:MM:ss"): Date? = SimpleDateFormat(format, Locale.getDefault()).parse(this)
