package com.technicalrupu.learningweek1

import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.technicalrupu.learningweek1.Helper.Activity
import com.technicalrupu.learningweek1.Helper.TimePicker
import com.technicalrupu.learningweek1.TimePicker.ClockModeActivity
import com.technicalrupu.learningweek1.TimePicker.SpinnerModeActvity
import java.text.SimpleDateFormat
import java.util.*

class TimePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)
        title="Time Picker"

        val timePicker= TimePicker(this)
        val btn = com.technicalrupu.learningweek1.Helper.Button(this)
        val activity = Activity(this)

        val btnClock = btn.create(R.id.btnClockMode)
        btnClock.setOnClickListener {
            activity.startActivity(ClockModeActivity())
        }

        val btnSpinner = btn.create(R.id.btnSpinnerMode)
        btnSpinner.setOnClickListener {
            activity.startActivity(SpinnerModeActvity())
        }
            timePicker.dialogTimePicker(R.id.clockModeTextView)

    }

}