package com.user.nestmarket.utils.helper.date

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object DateHelper {
    fun getCurrentYear(): Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }

    /*Input Format : 2022-01-27T05:18:03.89+05:30*/
    /*Input Format : 2022-01-27T05:18:03.89*/
    /*Output Format : MM/dd/yyyy hh:mm a*/
    @SuppressLint("SimpleDateFormat")
    fun convertDateAndTime(date: String): String {
        val fmtIn = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
        val formattedDate: Date? = fmtIn.parse(date)

        val fmtOut = SimpleDateFormat("MM/dd/yyyy hh:mm a")
        return formattedDate?.let { fmtOut.format(it) }.toString()
    }
}