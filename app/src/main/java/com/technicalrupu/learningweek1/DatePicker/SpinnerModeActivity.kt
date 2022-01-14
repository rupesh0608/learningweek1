package com.technicalrupu.learningweek1.DatePicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technicalrupu.learningweek1.Helper.DatePicker
import com.technicalrupu.learningweek1.R

class SpinnerModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_mode)
        title="Spinner Mode"

        val datePicker= DatePicker(this)
        datePicker.create(R.id.date_Picker,R.id.output)
    }
}