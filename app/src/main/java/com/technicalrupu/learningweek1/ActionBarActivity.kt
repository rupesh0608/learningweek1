package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActionBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar)
        title="Action Bar"


        val btnChange=findViewById<Button>(R.id.btnChange)
        btnChange.setOnClickListener{
            val editText=findViewById<EditText>(R.id.textBox)
            title=editText.text.toString()

        }
    }
}