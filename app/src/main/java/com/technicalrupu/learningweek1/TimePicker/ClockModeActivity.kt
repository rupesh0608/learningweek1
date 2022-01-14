package com.technicalrupu.learningweek1.TimePicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TimePicker
import com.technicalrupu.learningweek1.R

class ClockModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock_mode)
        title = "Clock Mode"

        val timePicker=com.technicalrupu.learningweek1.Helper.TimePicker(this)
        timePicker.create(R.id.clockPicker,R.id.output)
    }
}