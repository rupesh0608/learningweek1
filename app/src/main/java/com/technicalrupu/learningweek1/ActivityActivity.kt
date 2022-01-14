package com.technicalrupu.learningweek1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.technicalrupu.learningweek1.Activity.NewEmptyActivity
import com.technicalrupu.learningweek1.Activity.SendMsgActivity

class ActivityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_activity)
        title="Activity"
         val activity=com.technicalrupu.learningweek1.Helper.Activity(this)
        val btnOpenNewActivity = findViewById<Button>(R.id.openNewActivity)

        btnOpenNewActivity.setOnClickListener {
            activity.startActivity( NewEmptyActivity())
        }
        val btnSendMsgToNewActivity = findViewById<Button>(R.id.sendMsg)

        btnSendMsgToNewActivity.setOnClickListener {
            val msg = findViewById<EditText>(R.id.textBox)
            activity.passMsg( SendMsgActivity(), "text",msg.text.toString())
        }
        val btnActivityWithAnimation = findViewById<Button>(R.id.activityWithAnimation)

        btnActivityWithAnimation.setOnClickListener {
            activity.withAnimation(NewEmptyActivity(),R.anim.slide_in_up,R.anim.slide_in_down)
        }


    }



}