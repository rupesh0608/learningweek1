package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast

class AutoCompleteTextView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete_text_view)
        title="Auto complete Text View"
        val languages= arrayOf("C Language","c++","java","Python","Perl","C#","JavaScript","Swift","Golang (Go)")
       val act=com.technicalrupu.learningweek1.Helper.AutoCompleteTextView(this)

        val autoTextView=act.create(R.id.autoTextView,languages)

        val button = findViewById<Button>(R.id.btnSubmit)
        button?.setOnClickListener(View.OnClickListener {
            val enteredText = "Submitted Languages:"+ " " + autoTextView.text
            Toast.makeText(this, enteredText, Toast.LENGTH_SHORT).show()
        })
    }
}