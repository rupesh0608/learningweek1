package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technicalrupu.learningweek1.DatePicker.CalendarModeActivity
import com.technicalrupu.learningweek1.DatePicker.SpinnerModeActivity
import com.technicalrupu.learningweek1.Helper.Activity
import com.technicalrupu.learningweek1.Helper.DatePicker
import java.util.*


class DatePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        title = "Date Picker"
        val datePicker = DatePicker(this)
        val btn = com.technicalrupu.learningweek1.Helper.Button(this)
        val activity = Activity(this)

        val btnCalendar = btn.create(R.id.btnCalendarMode)
        btnCalendar.setOnClickListener {
            activity.startActivity(CalendarModeActivity())
        }

        val btnSpinner = btn.create(R.id.btnSpinnerMode)
        btnSpinner.setOnClickListener {
            activity.startActivity(SpinnerModeActivity())
        }
        datePicker.dialog(R.id.dialogTextView)
    }
}