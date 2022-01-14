package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.app.TimePickerDialog
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TimePicker
import com.technicalrupu.learningweek1.R
import java.text.SimpleDateFormat
import java.util.*

class TimePicker(val ref:Activity) {


    fun create(TimePickerid:Int,TextViewId:Int) {
        val textView = ref.findViewById<TextView>(TextViewId)
        val timePicker = ref.findViewById<TimePicker>(TimePickerid)
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""
            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
            if (textView != null) {
                val hour = if (hour < 10) "0" + hour else hour
                val min = if (minute < 10) "0" + minute else minute
                val msg = "Time is: $hour : $min $am_pm"
                textView.text = msg
                textView.visibility = ViewGroup.VISIBLE
            }
        }
    }
    fun dialogTimePicker(TextViewId: Int){

        val textView=ref.findViewById<TextView>(TextViewId)
            val cal = Calendar.getInstance()

            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                textView.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            textView.setOnClickListener {
                TimePickerDialog(ref, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
            }
    }
}