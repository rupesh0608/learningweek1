package com.technicalrupu.learningweek1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.technicalrupu.learningweek1.Helper.Button
import com.technicalrupu.learningweek1.StartActivityForResultFolder.StartActivityForResult2

class StartActivityForResult : AppCompatActivity() {

    val REQUEST_CODE=2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_for_result)
        title="start Activity for Result"

       val btn=Button(this)
        val getMsg=btn.create(R.id.getMsg)
        getMsg.setOnClickListener{
           val act=com.technicalrupu.learningweek1.Helper.Activity(this)
            act.setActivityForResult(StartActivityForResult2(),REQUEST_CODE)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val act=com.technicalrupu.learningweek1.Helper.Activity(this)

        val returnString= data?.let {
            act.receiveActivityForResult(requestCode,resultCode,
                it,"Key Name")
        }
        val textView = findViewById<TextView>(R.id.textView1)
        textView.text = returnString
    }

}