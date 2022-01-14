package com.technicalrupu.learningweek1.StartActivityForResultFolder

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.technicalrupu.learningweek1.R

class StartActivityForResult2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_for_result2)
        title="Start Activity for Result 2"
       val btn=com.technicalrupu.learningweek1.Helper.Button(this)
        val sendMsg=btn.create(R.id.sendMsg)
        sendMsg.setOnClickListener{
            val editText = findViewById<EditText>(R.id.editText)
            val stringToPassBack = editText.text.toString()
            val act=com.technicalrupu.learningweek1.Helper.Activity(this)
            act.sendActivityForResultSuccessfully("Key Name",stringToPassBack)
        }
    }
}