package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.technicalrupu.learningweek1.Helper.RadioButton

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button2)
        title = "Radio Buttons"
        val radio = RadioButton(this)

        radio.create(R.id.radioApp)
        radio.create(R.id.radioWeb)
        radio.create(R.id.radioFlutter)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener {
            val output = findViewById<TextView>(R.id.output)
            output.text = radio.getValue(R.id.radioGroup)
        }

    }
}