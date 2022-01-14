package com.technicalrupu.learningweek1.Helper

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import java.text.SimpleDateFormat
import java.util.*

class DatePicker(val ref:Activity) {

    fun create(DatePickerId:Int,TextViewId:Int){
        val datePicker = ref.findViewById<DatePicker>(DatePickerId)
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            val textView=ref.findViewById<TextView>(TextViewId)
            textView.text=msg
        }

    }

    @SuppressLint("SimpleDateFormat")
    fun dialog(TextViewId: Int){

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

       val textView=ref.findViewById<TextView>(TextViewId)
        val cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)

        }
        textView.setOnClickListener {
            DatePickerDialog(ref, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}