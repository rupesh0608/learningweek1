package com.technicalrupu.learningweek1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.technicalrupu.learningweek1.R

class SendMsgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_msg)
            val textMsg= intent.getStringExtra("text")
            val textView=findViewById<TextView>(R.id.msg)
        textView.text = textMsg


    }
}