package com.technicalrupu.learningweek1.TimePicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technicalrupu.learningweek1.R

class SpinnerModeActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_mode_actvity)
        title="Spinner Mode"
        val timePicker=com.technicalrupu.learningweek1.Helper.TimePicker(this)
        timePicker.create(R.id.spinnerPicker,R.id.output)
    }
}